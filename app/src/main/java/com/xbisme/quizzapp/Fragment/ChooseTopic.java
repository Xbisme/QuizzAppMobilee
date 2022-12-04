package com.xbisme.quizzapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.xbisme.quizzapp.R;
import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

public class ChooseTopic extends Fragment implements View.OnClickListener {

    private TextView topic1;
    private TextView topic2;
    private TextView topic3;
    private TextView topic4;
    private TextView topic5;
    private TextView topic6;
    private Topic_Level_ViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_choose_topic, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(v,saveInstanceState);
        topic1 = v.findViewById(R.id.topic1);
        topic2 = v.findViewById(R.id.topic2);
        topic3 = v.findViewById(R.id.topic3);
        topic4 = v.findViewById(R.id.topic4);
        topic5 = v.findViewById(R.id.topic5);
        topic6 = v.findViewById(R.id.topic6);
        topic1.setOnClickListener(this);
        topic2.setOnClickListener(this);
        topic3.setOnClickListener(this);
        topic4.setOnClickListener(this);
        topic5.setOnClickListener(this);
        topic6.setOnClickListener(this);
        viewModel = new ViewModelProvider(requireActivity()).get(Topic_Level_ViewModel.class);
    }
    @Override
    public void onClick(View view) {
        AppCompatButton button = (AppCompatButton) view;
        viewModel.setTopic(button.getText().toString());
        Navigation.findNavController(button).navigate(R.id.action_chooseTopic_to_chooseLevel);
    }
}