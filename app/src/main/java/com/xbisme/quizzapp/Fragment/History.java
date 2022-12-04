package com.xbisme.quizzapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.xbisme.quizzapp.DataBase.HistoryData;
import com.xbisme.quizzapp.DataBase.HistoryDataBase;
import com.xbisme.quizzapp.DataBase.ItemDAO;
import com.xbisme.quizzapp.Fragment.Adapter.HistoryAdapter;
import com.xbisme.quizzapp.R;

import java.util.List;


public class History extends Fragment {
    RecyclerView recyclerView;
    AppCompatButton finish;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        finish = view.findViewById(R.id.finish);
        HistoryDataBase dataBase = Room.databaseBuilder(requireContext(), HistoryDataBase.class, "mydb").allowMainThreadQueries().build();
        ItemDAO itemDAO = dataBase.getItemDAO();
        List<HistoryData> items = itemDAO.getItems();
        HistoryAdapter historyAdapter = new HistoryAdapter(getContext(), items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(historyAdapter);

    }
}