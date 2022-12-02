package com.xbisme.quizzapp.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")
public class HistoryData {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String date;
    private String topic;
    private String level;
    private String score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
//    @NonNull
//    @Override
//    public String toString () {
//
//        return getTopic() + "\n" + getLevel() + "\n" + getDate();
//    }
}
