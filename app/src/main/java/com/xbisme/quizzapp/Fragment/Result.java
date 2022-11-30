package com.xbisme.quizzapp.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xbisme.quizzapp.MainActivity;
import com.xbisme.quizzapp.R;
import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;


public class Result extends Fragment {
    private Topic_Level_ViewModel viewModel;
    private Integer score;
    private AppCompatButton finish;
    private AppCompatButton share;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(v,saveInstanceState);
        finish = v.findViewById(R.id.finish);
        share = v.findViewById(R.id.share);
        textView =v.findViewById(R.id.score);
        textView.setText(MainActivity.getScore().toString() + "/5");
        String share_text = "Tôi đã trả lời đúng " + textView.getText().toString() +
                " câu hỏi cấp độ " + MainActivity.getLevel().toString() +
                " ở chủ đề " + MainActivity.getTopic().toString();
        viewModel = new ViewModelProvider(requireActivity()).get(Topic_Level_ViewModel.class);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(finish).navigate(R.id.action_result_to_chooseTopic);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send_intent = new Intent(Intent.ACTION_SEND);
                System.out.println(share_text);
                send_intent.putExtra(Intent.EXTRA_TEXT,share_text);
                send_intent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(send_intent,null);
                startActivity(shareIntent);
            }
        });
    }
}