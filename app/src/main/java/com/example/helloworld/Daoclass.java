package com.example.helloworld;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

    @Dao
    public interface Daoclass {
        @Insert
        void insertAllData(dbwifi model);

        @Insert
        void insertAlld1(dbaprssi model);


        //Select All Data
        @Query("select * from wifidatabase ")
        List<dbwifi> getAllData();

        @Query("select * from Wardrivingdb ")
        List<dbaprssi> getAllD1();




}
