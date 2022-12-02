package com.xbisme.quizzapp.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDAO {

    @Insert
    void insert(HistoryData... items);
    @Update
    void update(HistoryData... items);
    @Delete
    void delete(HistoryData items);

    @Query("SELECT * FROM items")
    List<HistoryData> getItems();

}
