package com.example.helloworld;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
@Entity(tableName = "GPSdb")
public class GPSdb implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;

    @ColumnInfo(name = "xvalue")
    private double xval;

    @ColumnInfo(name = "yvalue")
    private double yval;



    public int getKey() {
        return key;

    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getXval() {
        return xval;
    }

    public double getYval() {
        return yval;
    }


    public void setXval(double xval) {
        this.xval = xval;
    }

    public void setYval(double yval) {
        this.yval = yval;
    }


}


