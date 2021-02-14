package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broad extends BroadcastReceiver {

    public Broad(){

    }


    @Override
    public void onReceive(Context context, Intent intent)
    {

         if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED))
        {
            Toast.makeText(context, "Charger is Disconnected", Toast.LENGTH_LONG).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_BATTERY_LOW))
        {
            Toast.makeText(context, "Battery is  Low", Toast.LENGTH_LONG).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_BATTERY_OKAY))
        {
            Toast.makeText(context, "Battery is Okay", Toast.LENGTH_LONG).show();
        }
        else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        {
            Toast.makeText(context, "Charger is Connected", Toast.LENGTH_LONG).show();
        }
    }




}
