package com.xbisme.quizzapp.DataBase;


import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {HistoryData.class}, version = 1)
public abstract class HistoryDataBase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();

}
