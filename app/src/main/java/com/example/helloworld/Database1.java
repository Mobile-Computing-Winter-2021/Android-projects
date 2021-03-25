package com.example.helloworld;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
 import com.example.helloworld.Acceloroom;
import com.example.helloworld.Daoclass;
import android.content.Context;

import androidx.room.Database;


@Database(entities = {Acceloroom.class,GPSdb.class,Lightdb.class,Lineardb.class,Proximity.class,Temperaturedb.class}, version = 7,exportSchema = false)
public abstract class Database1 extends RoomDatabase{




    private static Database1 db;

    private static String DATABASE_NAME = "Sensor";

    public synchronized static Database1 getInstance(Context context){

        if(db == null){

            db= Room.databaseBuilder(context.getApplicationContext() ,Database1.class
                    , DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return db;
    }
    public abstract Daoclass mainDao();

}

