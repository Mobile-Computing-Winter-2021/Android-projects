package com.example.helloworld;

import android.content.Context;

import java.util.ArrayList;

public class singleton {



    private static singleton singletonClass;
    ArrayList<Student> detailsHolder = new ArrayList<>();

    public ArrayList<Student> getDetailsHolder()
    {
        return detailsHolder;
    }

    public void setDetailsHolder(ArrayList<Student> detailsHolder)
    {
        this.detailsHolder = detailsHolder;
    }

    public static singleton get(Context context)
    {

        if (singletonClass == null) {
            singletonClass = new singleton(context);
        }
        return singletonClass;
    }




    private singleton(Context context)
    {
    }

}

