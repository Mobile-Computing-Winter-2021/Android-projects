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
    TextView t2;
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
        t2 = (TextView) view.findViewById(R.id.textView4);
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

                      float totaleuclid;
                       for(int i = 0;i<values.size();i++)
                    {
                         float x=(values.get(i).getRSSIAP1())-(rssilist1.get(indexofgalaxy));
                      float y=(values.get(i).getRSSIAP2())-(rssilist1.get(indexofredmi));
                        float z=(values.get(i).getRSSIAP3())-(rssilist1.get(indexofredmi1));
                        float eucled = (float) Math.sqrt((x)*(x) +(y)*(y)+(z)*(z));


                        eucledian.add(eucled);

                    }
                    int minIndex = eucledian.indexOf(Collections.min(eucledian));
                    if((minIndex==0)||(minIndex==1)||(minIndex==2)||(minIndex==3))
                    {
                      t1.setText("YOU ARE AT ROOM 1");
                      System.out.println("YOU ARE AT ROOM 1");
                    }

                   else if((minIndex==4)||(minIndex==5)||(minIndex==6)||(minIndex==7))
                    {
                        t1.setText("YOU ARE AT ROOM 2");
                        System.out.println("YOU ARE AT ROOM 2");
                    }
                   else if((minIndex==8)||(minIndex==9)||(minIndex==10)||(minIndex==11))
                    {
                        t1.setText("YOU ARE AT ROOM 3");
                        System.out.println("YOU ARE AT ROOM 3");
                    }
                   else if((minIndex==12)||(minIndex==13)||(minIndex==14)||(minIndex==15))
                    {
                        t1.setText("YOU ARE AT ROOM 4");
                        System.out.println("YOU ARE AT ROOM 4");
                    }
                  else if((minIndex==16)||(minIndex==17)||(minIndex==18)||(minIndex==19))
                    {
                        t1.setText("YOU ARE AT ROOM 5");
                        System.out.println("YOU ARE AT ROOM 5");
                    }
                else if((minIndex==20)||(minIndex==21)||(minIndex==22)||(minIndex==23))
                    {
                        t1.setText("YOU ARE AT ROOM 6");
                        System.out.println("YOU ARE AT ROOM 6");
                    }



                                        }
            });
            accz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//I have taken k value as 7
                    List<dbaprssi> values1 = Databaseclass.getInstance(getActivity()).mainDao().getAllD1();
                    for (int i = 0; i < values1.size(); i++) {
                        float x = (values1.get(i).getRSSIAP1()) - (rssilist1.get(indexofgalaxy));
                        float y = (values1.get(i).getRSSIAP2()) - (rssilist1.get(indexofredmi));
                        float z = (values1.get(i).getRSSIAP3()) - (rssilist1.get(indexofredmi1));
                        float eucled = (float) Math.sqrt((x) * (x) + (y) * (y) + (z) * (z));
                        eucledian1.add(eucled);

                    }
                    //   int minIndex = eucledian.indexOf(Collections.min(eucledian));
                    int roomcount1 = 0;
                    int roomcount2 = 0;
                    int roomcount3 = 0;
                    int roomcount4 = 0;
                    int roomcount5 = 0;
                    int roomcount6 = 0;
                    ArrayList<Float> copiedeucled
                            = (ArrayList<Float>) eucledian1.clone();

                    Collections.sort(eucledian1);

                    ArrayList<Integer> roomno = new ArrayList<>();
                    for (int i = 0; i < 7; i++) {

                        Float valueatposition = eucledian.get(i);
                        int originalpos = copiedeucled.indexOf(valueatposition);
                        if ((originalpos == 0) || (originalpos == 1) || (originalpos == 2) || (originalpos == 3)) {
                            roomcount1++;

                        }
                        if ((originalpos == 4) || (originalpos == 5) || (originalpos == 6) || (originalpos == 7)) {
                            roomcount2++;

                        }
                        if ((originalpos == 8) || (originalpos == 9) || (originalpos == 10) || (originalpos == 11)) {
                            roomcount3++;

                        }
                        if ((originalpos == 12) || (originalpos == 13) || (originalpos == 14) || (originalpos == 15)) {
                            roomcount4++;

                        }
                        if ((originalpos == 16) || (originalpos == 17) || (originalpos == 18) || (originalpos == 19)) {
                            roomcount5++;

                        }
                        if ((originalpos == 20) || (originalpos == 21) || (originalpos == 22) || (originalpos == 23)) {
                            roomcount6++;

                        }
                    }


                    roomno.add(roomcount1);
                    roomno.add(roomcount2);
                    roomno.add(roomcount3);
                    roomno.add(roomcount4);
                    roomno.add(roomcount5);
                    roomno.add(roomcount6);

                    // calling max() method.
                    int largest = Collections.max(roomno);
                    int room = roomno.indexOf(largest);
                    if (room == 0) {
                        t2.setText("YOU ARE AT ROOM 1");
                        System.out.println("YOU ARE AT ROOM 1");
                    }
                    if (room == 1) {
                        t2.setText("YOU ARE AT ROOM 2");
                        System.out.println("YOU ARE AT ROOM 2");
                    }
                    if (room == 2) {
                        t2.setText("YOU ARE AT ROOM 3");
                        System.out.println("YOU ARE AT ROOM 3");
                    }
                    if (room == 3) {
                        t2.setText("YOU ARE AT ROOM 4");
                        System.out.println("YOU ARE AT ROOM 4");
                    }
                    if (room == 4) {
                        t2.setText("YOU ARE AT ROOM 5");
                        System.out.println("YOU ARE AT ROOM 5");
                    }
                    if (room == 5) {
                        t2.setText("YOU ARE AT ROOM 6");
                        System.out.println("YOU ARE AT ROOM 6");
                    }


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






