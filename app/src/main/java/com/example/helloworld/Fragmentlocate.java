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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Fragmentlocate extends Fragment {
    WifiManager wifimanager1;
    WifiReceiver3 wifiReceiver1;
    ADapterlist listAdapter1;
    ListView wifiList4;
    List mywifiList2;
    List result1;
    Button accx;
    Button accz;
    TextView t1;
     ArrayList wifiList3;

    List AP1difference;
    List AP2difference;
    List AP3difference;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_fragmentlocate, container, false);
       accx = (Button) view.findViewById(R.id.button2);
       accz = (Button) view.findViewById(R.id.button7);
        t1 = (TextView) view.findViewById(R.id.textView);
        wifimanager1 = (WifiManager) getActivity().
                getSystemService(Context.WIFI_SERVICE);
        wifiReceiver1 = new WifiReceiver3();
        requireActivity().registerReceiver(wifiReceiver1, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
           dbaprssi model1 = new dbaprssi();
            wifimanager1.startScan();

            List<ScanResult> wifiList3 = wifimanager1.getScanResults();


            ArrayList<String> ssidlist1 = new ArrayList<>();
            ArrayList<Float> rssilist1 = new ArrayList<>();
            ArrayList<Float> eucledian = new ArrayList<>();
            ArrayList<Float> eucledian1 = new ArrayList<>();
            for (ScanResult scanResult : wifiList3) {

                ssidlist1.add(scanResult.SSID);
            }
            for (ScanResult scanResult : wifiList3) {

                rssilist1.add((float) (scanResult.level));
            }

          // int indexofanku=ssidlist1.indexOf("ONEPLUS_co_apkhrf");
            int indexofredmi=ssidlist1.indexOf("Redmi");
            int indexofredmi1=ssidlist1.indexOf("Redmi1");
            int indexofgalaxy=ssidlist1.indexOf("Galaxy M21A406");

            accx.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            List<dbaprssi> values = Databaseclass.getInstance(getActivity()).mainDao().getAllD1();
                                            for (int i = 0; i < values.size(); i++) {
                                                System.out.println("THE LIst are" + values.get(i).getRSSIAP1());

                                            }


                       for(int i = 0;i<values.size();i++)
                    {
                         float x=(values.get(i).getRSSIAP1())-(rssilist1.get(indexofgalaxy));
                      float y=(values.get(i).getRSSIAP2())-(rssilist1.get(indexofredmi));
                        float z=(values.get(i).getRSSIAP3())-(rssilist1.get(indexofredmi1));
                        float eucled = (float) Math.sqrt((x)*(x) +(z)*(z));
                        eucledian.add(eucled);

                    }
                    int minIndex = eucledian.indexOf(Collections.min(eucledian));
                    if(minIndex==0)
                    {
                      t1.setText("YOU ARE AT ROOM 1");
                      System.out.println("YOU ARE AT ROOM 1");
                    }

                   else if(minIndex==1)
                    {
                        t1.setText("YOU ARE AT ROOM 2");
                        System.out.println("YOU ARE AT ROOM 2");
                    }
                   else if(minIndex==2)
                    {
                        t1.setText("YOU ARE AT ROOM 3");
                        System.out.println("YOU ARE AT ROOM 3");
                    }
                   else if(minIndex==3)
                    {
                        t1.setText("YOU ARE AT ROOM 4");
                        System.out.println("YOU ARE AT ROOM 4");
                    }
                  else if(minIndex==4)
                    {
                        t1.setText("YOU ARE AT ROOM 5");
                        System.out.println("YOU ARE AT ROOM 5");
                    }
                else if(minIndex==5)
                    {
                        t1.setText("YOU ARE AT ROOM 6");
                        System.out.println("YOU ARE AT ROOM 6");
                    }








                }
            });
            accz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                            List<dbaprssi> values1  = Databaseclass.getInstance(getActivity()).mainDao().getAllD1();
                            for(int i = 0;i<values1.size();i++)
                            {
                                float x=(values1.get(i).getRSSIAP1())-(rssilist1.get(indexofgalaxy));
                              float y=(values1.get(i).getRSSIAP2())-(rssilist1.get(indexofredmi));
                                float z=(values1.get(i).getRSSIAP3())-(rssilist1.get(indexofredmi1));
                                float eucled = (float) Math.sqrt((x)*(x) +(y)*(y)+(z)*(z));
                                eucledian1.add(eucled);

                            }
                            int minIndex = eucledian.indexOf(Collections.min(eucledian));






                }
            });


        }

                    return view;
                }


                class WifiReceiver3 extends BroadcastReceiver {

                    @Override
                    public void onReceive(Context context, Intent intent) {

                    }
                }

    }






