package com.example.helloworld;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.helloworld.Acceloroom;
import com.example.helloworld.Database1;


import java.util.List;
@Dao
public interface Daoclass {
    @Insert
    void insertAllData(Acceloroom model);

   @Insert
    void insertDatatemp(Temperaturedb model);

   @Insert
    void insertAllProx(Proximity model);

    @Insert
    void insertAllLinear(Lineardb model);


  @Insert
    void insertAllLight(Lightdb model);

    @Insert
  void insertAllDataGps(GPSdb model);

    //Select All Data
    @Query("select * from Accelerometer ")
    List<Acceloroom> getAllData();



    @Query("select * from  Lightdb")
   List<Lightdb> getAllDatalight();


   @Query("select * from  GPSdb")
   List<GPSdb> getAllDataGPS();


    @Query("select * from  Proximitydb")
    List<Proximity> getAllProx();


    @Query("select * from  Lineardb")
    List<Lineardb> getAlllinear();


   @Query("select * from  Temperaturedb")
    List<Temperaturedb> getAlltemp();


    //DELETE DATA
   // @Query("delete from Accelerometer where `key`= :id")
    //void deleteData(int id);

    //Update Data

   // @Query("update Accelerometer SET name= :name ,address =:address, phoneno =:phoneno where `key`= :key")
   // void updateData(String name, String phoneno, String address, int key);


}
