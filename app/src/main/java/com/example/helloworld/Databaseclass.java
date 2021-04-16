package com.example.helloworld;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.helloworld.dbwifi;
import com.example.helloworld.Daoclass;
import android.content.Context;

import androidx.room.Database;
@Database(entities = {dbwifi.class}, version = 1,exportSchema = false)
public abstract class Databaseclass extends RoomDatabase{
    private static Databaseclass db;

    private static String DATABASE_NAME = "Wifi";

    public synchronized static Databaseclass getInstance(Context context){

        if(db == null){

            db= Room.databaseBuilder(context.getApplicationContext() ,Databaseclass.class
                    , DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return db;
    }
    public abstract Daoclass mainDao();

}



