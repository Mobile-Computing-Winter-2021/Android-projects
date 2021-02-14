package com.example.helloworld;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    Broad Receiver1 = new Broad();
    final static int MY_PERMISSIONS_REQUEST = 1;
    public static final String TAG1 = "THE_FIRST_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Button  download = (Button) findViewById(R.id.button);
         Button  playmusic = (Button) findViewById(R.id.button2);
        playmusic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment frag1 = fm.findFragmentById(R.id.fragment_container);
                if (frag1 == null) {
                    Log.i(TAG1, "fragment is  null");
                    frag1 = new MusicFragment();
                    fm.beginTransaction().add(R.id.fragment_container, frag1).commit();
                }
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DownloadActivity.class);
                startActivity(intent);
           }
       });

    }

    /*   @Override
       protected void onStart() {
           super.onStart();
          IntentFilter filter = new IntentFilter();
           filter.addAction(Intent.ACTION_BATTERY_LOW);
           filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
           filter.addAction(Intent.ACTION_POWER_CONNECTED);
           filter.addAction(Intent.ACTION_BATTERY_OKAY);
           registerReceiver(Receiver1, filter);

       }
       @Override
       protected void onStop() {
           super.onStop();
           unregisterReceiver(Receiver1);
       }

   }*/
    @Override
    public void onResume()
    {
        super.onResume();
         Receiver1 = new Broad();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_BATTERY_OKAY);
        registerReceiver(Receiver1, filter);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        unregisterReceiver(Receiver1);
    }



}
