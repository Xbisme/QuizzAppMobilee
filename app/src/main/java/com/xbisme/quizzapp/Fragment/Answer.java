package com.xbisme.quizzapp.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.xbisme.quizzapp.Activity.MainActivity;
import com.xbisme.quizzapp.Question.AndroidQues;
import com.xbisme.quizzapp.Question.AnimeQues;
import com.xbisme.quizzapp.Question.DocumentaryQues;
import com.xbisme.quizzapp.Question.FilmQues;
import com.xbisme.quizzapp.Question.GameQues;
import com.xbisme.quizzapp.Question.IosQues;
import com.xbisme.quizzapp.R;
import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

public class Answer extends Fragment implements View.OnClickListener {
    private AppCompatButton trueAnswer;
    private AppCompatButton falseAnswer;
    private ProgressBar progressBar;
    private int currentQues = 0;
    private final int USER_PROGRESS = 20;
    private TextView textView;
    private Integer score = 0;
    private Topic_Level_ViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_answer, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view,saveInstanceState);
        trueAnswer = view.findViewById(R.id.True);
        falseAnswer = view.findViewById(R.id.False);
        textView = view.findViewById(R.id.textview_main_answer);
        progressBar = view.findViewById(R.id.progress_bar);
        trueAnswer.setOnClickListener(this);
        falseAnswer.setOnClickListener(this);
        viewModel = new ViewModelProvider(requireActivity()).get(Topic_Level_ViewModel.class);
        loadQuestion();
    }

    @Override
    public void onClick(View view) {
        AppCompatButton button = (AppCompatButton) view;
        checkPoint(button);
        if(currentQues == 4) {
            viewModel.setScore(score);
            Navigation.findNavController(button).navigate(R.id.action_answer_to_result);
        }
        else
            switchQuestion();

    }
    private void loadQuestion () {
        switch (MainActivity.getTopic()) {
            case "Game":
                if (MainActivity.getLevel().equals("Dễ")) textView.setText(GameQues.easy_question[currentQues]);
                else if (MainActivity.getLevel().equals("Trung Bình")) textView.setText(GameQues.normal_question[currentQues]);
                else textView.setText(GameQues.hard_question[currentQues]);
                break;
            case "Anime":
                if (MainActivity.getLevel().equals("Dễ") ) textView.setText(AnimeQues.easy_question[currentQues]);
                else if (MainActivity.getLevel().equals("Trung Bình")) textView.setText(AnimeQues.normal_question[currentQues]);
                else textView.setText(AnimeQues.hard_question[currentQues]);
                break;
            case "Film":
                if (MainActivity.getLevel().equals("Dễ") ) textView.setText(FilmQues.easy_question[currentQues]);
                else if (MainActivity.getLevel().equals("Trung Bình")) textView.setText(FilmQues.normal_question[currentQues]);
                else textView.setText(FilmQues.hard_question[currentQues]);
                break;
            case "Documentary":
                if (MainActivity.getLevel().equals("Dễ") ) textView.setText(DocumentaryQues.easy_question[currentQues]);
                else if (MainActivity.getLevel().equals("Trung Bình")) textView.setText(DocumentaryQues.normal_question[currentQues]);
                else textView.setText(DocumentaryQues.hard_question[currentQues]);
                break;
            case "Android":
                if (MainActivity.getLevel().equals("Dễ")) textView.setText(AndroidQues.easy_question[currentQues]);
                else if (MainActivity.getLevel().equals("Trung Bình")) textView.setText(AndroidQues.normal_question[currentQues]);
                else textView.setText(AndroidQues.hard_question[currentQues]);
                break;
            case "Ios":
                if (MainActivity.getLevel().equals("Dễ") ) textView.setText(IosQues.easy_question[currentQues]);
                else if (MainActivity.getLevel().equals("Trung Bình")) textView.setText(IosQues.normal_question[currentQues]);
                else textView.setText(IosQues.hard_question[currentQues]);
                break;
        }
        progressBar.incrementProgressBy(USER_PROGRESS);
    }
    private void switchQuestion() {
        currentQues++;
        loadQuestion();
    }
    private void checkPoint(AppCompatButton button) {
        switch (MainActivity.getTopic()) {
            case "Game":
                if (MainActivity.getLevel().equals("Dễ")  && button.getText().equals(GameQues.easy_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(GameQues.normal_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Khó")&& button.getText().equals(GameQues.hard_correctAnswer[currentQues]))
                    score++;
                break;
            case "Anime":
                if (MainActivity.getLevel().equals("Dễ")  && button.getText().equals(AnimeQues.easy_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(AnimeQues.normal_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Khó") && button.getText().equals(AnimeQues.hard_correctAnswer[currentQues]))
                    score++;
                break;
            case "Film":
                if (MainActivity.getLevel().equals("Dễ")  && button.getText().equals(FilmQues.easy_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(FilmQues.normal_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Khó") && button.getText().equals(FilmQues.hard_correctAnswer[currentQues]))
                    score++;
                break;
            case "Android":
                if (MainActivity.getLevel().equals("Dễ")  && button.getText().equals(AndroidQues.easy_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(AndroidQues.normal_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Khó") && button.getText().equals(AndroidQues.hard_correctAnswer[currentQues]))
                    score++;
                break;
            case "Ios":
                if (MainActivity.getLevel().equals("Dễ")  && button.getText().equals(IosQues.easy_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(IosQues.normal_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Khó") && button.getText().equals(IosQues.hard_correctAnswer[currentQues]))
                    score++;
                break;
            case "Documentary":
                if (MainActivity.getLevel().equals("Dễ")  && button.getText().equals(DocumentaryQues.easy_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Trung Bình") && button.getText().equals(DocumentaryQues.normal_correctAnswer[currentQues]))
                    score++;
                if (MainActivity.getLevel().equals("Khó") && button.getText().equals(DocumentaryQues.hard_correctAnswer[currentQues]))
                    score++;
                break;
        }
    }
}