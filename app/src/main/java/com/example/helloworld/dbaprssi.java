package com.example.helloworld;
import androidx.annotation.NonNull;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Wardrivingdb")
public class dbaprssi implements Serializable {




    //Primary key
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "Roomno")
    private int Roomno;

    @ColumnInfo(name = "RSSIAP1")
    private float RSSIAP1;
    @ColumnInfo(name = "RSSIAP2")
    private float RSSIAP2;
    @ColumnInfo(name = "RSSIAP3")
    private float RSSIAP3;






    public int getKey() {
        return key;

    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setRoomno(int roomno) {
        Roomno = roomno;
    }

    public void setRSSIAP1(float RSSIAP1) {
        this.RSSIAP1 = RSSIAP1;
    }

    public void setRSSIAP2(float RSSIAP2) {
        this.RSSIAP2 = RSSIAP2;
    }

    public void setRSSIAP3(float RSSIAP3) {
        this.RSSIAP3 = RSSIAP3;
    }

    public int getRoomno() {
        return Roomno;
    }

    public float getRSSIAP1() {
        return RSSIAP1;
    }

    public float getRSSIAP2() {
        return RSSIAP2;
    }

    public float getRSSIAP3() {
        return RSSIAP3;
    }
}




