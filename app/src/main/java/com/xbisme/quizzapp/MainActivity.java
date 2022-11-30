package com.xbisme.quizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.xbisme.quizzapp.ViewModel.Topic_Level_ViewModel;

public class MainActivity extends AppCompatActivity {
    private Topic_Level_ViewModel viewModel;
    private static String topic;
    private static String level;
    private static Integer score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(Topic_Level_ViewModel.class);

        viewModel.getTopic().observe(this,item -> {
            setTopic(item);
        });
        viewModel.getLevel().observe(this,item -> {
            setLevel(item);
        });
        viewModel.getScore().observe(this,item-> {
            setScore(item);
        });
    }
    public static String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public static String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}