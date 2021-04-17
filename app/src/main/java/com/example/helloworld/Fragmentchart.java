package com.example.helloworld;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import android.net.wifi.ScanResult;
import android.content.Intent;
import android.widget.Button;

public class Fragmentchart extends Fragment {

    public static BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntriesArrayList;
    public static String list1;
    public static Button chartdisplay;

   // private ArrayList<ScanResult> aListModel = new ArrayList<ScanResult>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fragmentchart, container, false);
        barChart = (BarChart)view.findViewById(R.id.idofchart);
       // aListModel = (ArrayList<ScanResult>) getActivity().getIntent().getSerializableExtra("list1");
        chartdisplay=(Button)view.findViewById(R.id.button6);

        return view;
    }
}

