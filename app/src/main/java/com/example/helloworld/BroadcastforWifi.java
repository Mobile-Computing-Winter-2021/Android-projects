package com.example.helloworld;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BroadcastforWifi extends BroadcastReceiver {


    StringBuilder strings;
    ListView DeviceList;
    public static ArrayList wifiList;
   BarData Data;
    BarDataSet DataSet;
    ArrayList barEntries;
    public static String list1;
    WifiManager wifiManager;

    public BroadcastforWifi(WifiManager wifiManager, ListView DeviceList) {
        this.wifiManager = wifiManager;
        this.DeviceList = DeviceList;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION.equals(action)) {
            strings = new StringBuilder();
            ArrayList<String> deviceList = new ArrayList<>();

            List<ScanResult> wifiList = wifiManager.getScanResults();



            for (ScanResult scanResult : wifiList) {
                strings.append("\n").append(scanResult.SSID).append(" - ").append("     RSSI:");
                deviceList.add("SSID: " + scanResult.SSID + "                 RSSI VALUE: " + scanResult.level);
            }
            //Bundle args = new Bundle();
            // args.putSerializable("list1", (Serializable) wifiList);

            // Fragmentchart teamFragment = new Fragmentchart();
            //  teamFragment.setArguments(args);


            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, deviceList.toArray());
            DeviceList.setAdapter(arrayAdapter);
            Fragmentchart.chartdisplay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    barEntries = new ArrayList<>();
                    for (int i = 0; i < wifiList.size(); i++) {


                        barEntries.add(new BarEntry((float) i, wifiManager.calculateSignalLevel(wifiList.get(i).level, 20)));
                    }
                    ArrayList<String> labels = new ArrayList<>();
                    for (int i = 0; i < wifiList.size(); i++) {
                        labels.add(wifiList.get(i).SSID);
                    }


                    Fragmentchart.barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
                    DataSet = new BarDataSet(barEntries, "Signal Strength");
                    Data = new BarData(DataSet);
                    Fragmentchart.barChart.setData(Data);


                    DataSet.setColors(ColorTemplate.COLORFUL_COLORS);


                    DataSet.setValueTextColor(Color.BLUE);

                    XAxis xAxis = Fragmentchart.barChart.getXAxis();
                    xAxis.setGranularity(1f);
                    xAxis.setGranularityEnabled(true);

                    DataSet.setValueTextSize(12f);
                    Fragmentchart.barChart.getDescription().setEnabled(false);
                }
            });


        }
    }


            }




