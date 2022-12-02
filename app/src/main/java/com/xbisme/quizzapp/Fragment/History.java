package com.xbisme.quizzapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xbisme.quizzapp.DataBase.HistoryData;
import com.xbisme.quizzapp.DataBase.HistoryDataBase;
import com.xbisme.quizzapp.DataBase.ItemDAO;
import com.xbisme.quizzapp.Fragment.Adapter.HistoryAdapter;
import com.xbisme.quizzapp.R;

import java.util.List;


public class History extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        HistoryDataBase dataBase = Room.databaseBuilder(requireContext(), HistoryDataBase.class,"mydb").allowMainThreadQueries().build();
        ItemDAO itemDAO = dataBase.getItemDAO();
        List<HistoryData> items = itemDAO.getItems();
        HistoryAdapter historyAdapter = new HistoryAdapter(getContext(), items);
        recyclerView.setAdapter(historyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }
}