package com.xbisme.quizzapp.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.xbisme.quizzapp.DataBase.HistoryData;
import com.xbisme.quizzapp.DataBase.HistoryDataBase;
import com.xbisme.quizzapp.DataBase.ItemDAO;
import com.xbisme.quizzapp.MainActivity;
import com.xbisme.quizzapp.R;
import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Result extends Fragment {
    private Topic_Level_ViewModel viewModel;
    private AppCompatButton finish;
    private AppCompatButton share;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(v,saveInstanceState);
        finish = v.findViewById(R.id.finish);
        share = v.findViewById(R.id.share);
        textView =v.findViewById(R.id.score);
        textView.setText(MainActivity.getScore().toString() + "/5");
        String share_text = "Tôi đã trả lời đúng " + textView.getText().toString() +
                " câu hỏi cấp độ " + MainActivity.getLevel() +
                " ở chủ đề " + MainActivity.getTopic();
        viewModel = new ViewModelProvider(requireActivity()).get(Topic_Level_ViewModel.class);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HistoryDataBase dataBase = Room.databaseBuilder(requireContext(),HistoryDataBase.class,"mydb").allowMainThreadQueries().build();
                ItemDAO itemDAO = dataBase.getItemDAO();
                HistoryData historyData = new HistoryData();
                historyData.setTopic(MainActivity.getTopic());
                historyData.setScore(MainActivity.getScore().toString().trim());
                historyData.setLevel(MainActivity.getLevel());
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar calendar = Calendar.getInstance();
                historyData.setDate(dateFormat.format(calendar.getTime()));
                itemDAO.insert(historyData);
                Toast.makeText(getContext(),"add success",Toast.LENGTH_LONG).show();
                Navigation.findNavController(finish).navigate(R.id.action_result_to_chooseTopic);
            }
        });
        share.setOnClickListener(view -> {
            Intent send_intent = new Intent(Intent.ACTION_SEND);
            System.out.println(share_text);
            send_intent.putExtra(Intent.EXTRA_TEXT,share_text);
            send_intent.setType("text/plain");
            Intent shareIntent = Intent.createChooser(send_intent,null);
            startActivity(shareIntent);
        });
    }
}