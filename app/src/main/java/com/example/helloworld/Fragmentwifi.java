package com.example.helloworld;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import com.example.helloworld.BroadcastforWifi;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.Manifest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.net.wifi.ScanResult;

import java.util.ArrayList;


public class Fragmentwifi extends Fragment {
    public static ListView wifiList;
    private WifiManager wifiManager;
    private final int MY_PERMISSIONS_ACCESS_COARSE_LOCATION = 1;
    BroadcastforWifi receiverWifi;
    public static Button scan;
    public static Button graph;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_fragmentwifi, container, false);


        wifiList = (ListView) view.findViewById(R.id.wifiList);
        scan = (Button) view.findViewById(R.id.button3);
        wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        if (!wifiManager.isWifiEnabled()) {
            Toast.makeText(getContext(), "Wifi is getting turned on", Toast.LENGTH_LONG).show();
         //   wifiManager.setWifiEnabled(true);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
                    } else {
                        wifiManager.startScan();
                    }
                }
            });
        }
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_ACCESS_COARSE_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "permission granted", Toast.LENGTH_SHORT).show();
                    wifiManager.startScan();
                } else {
                    Toast.makeText(getActivity(), "permission not granted", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }


    }

    @Override
    public void onResume() {
        super.onResume();


        receiverWifi = new BroadcastforWifi(wifiManager, wifiList);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        requireActivity().registerReceiver(receiverWifi, intentFilter);
        getWifi();
    }


    @Override
    public void onPause() {
        super.onPause();
        requireActivity().unregisterReceiver(receiverWifi);

    }

    private void getWifi() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(getContext(), "version> = marshmallow", Toast.LENGTH_SHORT).show();
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(), "location turned off", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_ACCESS_COARSE_LOCATION);
            } else{
                Toast.makeText(getActivity(), "location turned on", Toast.LENGTH_SHORT).show();
                wifiManager.startScan();
            }
        } else {
            Toast.makeText(getActivity(), "scanning", Toast.LENGTH_SHORT).show();
            wifiManager.startScan();
        }
    }
}