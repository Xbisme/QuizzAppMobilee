package com.xbisme.quizzapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Topic_Level_ViewModel extends ViewModel {
    private MutableLiveData<String> topic = new MutableLiveData<>();
    private MutableLiveData<String> level = new MutableLiveData<>();
    private MutableLiveData<Integer> score = new MutableLiveData<>();

    public void setTopic(String topic) {
        this.topic.setValue(topic);
    }
    public void setLevel(String level) {
        this.level.setValue(level);
    }
    public void setScore(Integer score) {
        this.score.setValue(score);
    }
    public LiveData<String> getTopic() {
        return topic;
    }
    public LiveData<String> getLevel() {
        return level;
    }
    public LiveData<Integer> getScore() {
        return score;
    }
}
