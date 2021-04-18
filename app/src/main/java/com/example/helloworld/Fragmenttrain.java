package com.example.helloworld;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Fragmenttrain extends Fragment {


    WifiManager wifimanager;
    WifiReceiver wifiReceiver;
    ADapterlist listAdapter;
    ListView wifiList;
    List mywifiList;
    List result;
    Button accy;
    EditText e1;
    public static ArrayList wifiList2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // accx = (Button) findViewById(R.id.button);
        // accy = (Button)view.findViewById(R.id.button5);
        View view = inflater.inflate(R.layout.fragment_fragmenttrain, container, false);
        accy = (Button) view.findViewById(R.id.button5);
        e1 = (EditText) view.findViewById(R.id.edit1);
        wifimanager = (WifiManager) getActivity().
                getSystemService(Context.WIFI_SERVICE);
        wifiReceiver = new WifiReceiver();
        requireActivity().registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            dbaprssi model1 = new dbaprssi();
            accy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wifimanager.startScan();

                    List<ScanResult> wifiList = wifimanager.getScanResults();


                    ArrayList<String> ssidlist = new ArrayList<>();
                    ArrayList<Float> rssilist = new ArrayList<>();
                    for (ScanResult scanResult : wifiList) {

                        ssidlist.add(scanResult.SSID);
                    }
                    for (ScanResult scanResult : wifiList) {

                        rssilist.add((float) (scanResult.level));
                    }


                    int roomno = Integer.parseInt(e1.getText().toString());
                    model1.setRoomno(roomno);
                   // model1.setRSSIAP1(0.0f);
                    //model1.setRSSIAP2(0.0f);
                   //model1.setRSSIAP3(0.0f);
                    for(int i = 0; i < ssidlist.size(); i++)
                    {
                        System.out.println(ssidlist.get(i));
                    }


                   for (int i = 0; i < ssidlist.size(); i++) {
                        if ((ssidlist.get(i)).equals("Galaxy M21A406")) {
                            model1.setRSSIAP1(rssilist.get(i));
                        } else if ((ssidlist.get(i)).equals("ONEPLUS_co_apkhrf")) {
                            model1.setRSSIAP2(rssilist.get(i));
                       } else if ((ssidlist.get(i)).equals("Redmi1")) {
                            model1.setRSSIAP3(rssilist.get(i));

                        }
                   }


                    Databaseclass.getInstance(getActivity()).mainDao().insertAlld1(model1);


                }
            });


        }

        return view;
    }

        // private <List> java.util.List scanWifiList() {

        // wifimanager.startScan();

        //  mywifiList = wifimanager.getScanResults();
        //return mywifiList;


        // setAdapter();


        // }


        class WifiReceiver extends BroadcastReceiver {

            @Override
            public void onReceive(Context context, Intent intent) {

            }
        }
    }




