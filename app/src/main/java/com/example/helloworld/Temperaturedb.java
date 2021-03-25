package com.example.helloworld;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "Temperaturedb")
public class Temperaturedb implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "xvalue")
    private float xval;



    public int getKey() {
        return key;

    }

    public void setKey(int key) {
        this.key = key;
    }

    public float getXval() {
        return xval;
    }


    public void setXval(float xval) {
        this.xval = xval;
    }


}




