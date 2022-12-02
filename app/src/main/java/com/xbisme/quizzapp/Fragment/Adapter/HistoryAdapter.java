package com.xbisme.quizzapp.Fragment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xbisme.quizzapp.DataBase.HistoryData;
import com.xbisme.quizzapp.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    Context context;
    List<HistoryData> historyList;

    public HistoryAdapter(Context context, List<HistoryData> historyList) {
        this.context = context;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryData historyDataBase = historyList.get(position);
        holder.topic.setText(historyDataBase.getTopic());
        holder.level.setText(historyDataBase.getLevel());
        holder.score.setText(historyDataBase.getScore());
        holder.date.setText(historyDataBase.getDate());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView topic,level,score,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.topic_his);
            level = itemView.findViewById(R.id.level_his);
            score = itemView.findViewById(R.id.score_his);
            date = itemView.findViewById(R.id.date_his);
        }
    }
}
