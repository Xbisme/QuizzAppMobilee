package com.xbisme.quizzapp.Fragment;

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

import com.xbisme.quizzapp.R;
import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

public class ChooseLevel extends Fragment implements View.OnClickListener{
    TextView easyLv;
    TextView normalLv;
    TextView hardLv;
    Topic_Level_ViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choose_level, container, false);

        return v;
    }
    public void onViewCreated(@NonNull View v, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(v,saveInstanceState);
        easyLv = v.findViewById(R.id.easy);
        normalLv = v.findViewById(R.id.normal);
        hardLv = v.findViewById(R.id.hard);
        easyLv.setOnClickListener(this);
        normalLv.setOnClickListener(this);
        hardLv.setOnClickListener(this);
        viewModel = new ViewModelProvider(requireActivity()).get(Topic_Level_ViewModel.class);
    }

    @Override
    public void onClick(View view) {
        AppCompatButton button = (AppCompatButton) view;
        viewModel.setLevel(button.getText().toString());
        Navigation.findNavController(button).navigate(R.id.action_chooseLevel_to_answer);
    }
}