package com.example.helloworld;

import androidx.annotation.NonNull;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "WifiDatabase")
    public class dbwifi implements Serializable {


        //Primary key
        @PrimaryKey(autoGenerate = true)
        @NonNull
        private int key;

        @ColumnInfo(name = "name")
        private String name;

        @ColumnInfo(name = "RSSI value")
        private float RSSI;






        public int getKey() {
            return key;

        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }
        public void setName(String name ) {
            this.name = name;
        }

        public float getRSSI() {
            return RSSI;
        }





        public void setRSSI(float RSSI) {
            this.RSSI = RSSI;
        }




    }


