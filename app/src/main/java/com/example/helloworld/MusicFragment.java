package com.example.helloworld;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;


public class MusicFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    String songs[] = new String[]{"Westworld", "first", "Friends", "National Anthem", "Jumanji drums", "Narcos ringtone"};
    String songname;
    Spinner spinner;
    public static String valueFromSpinner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        spinner = (Spinner) view.findViewById(R.id.spinner2);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, songs);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);
        Button play = (Button) view.findViewById(R.id.button5);
        Button stop = (Button) view.findViewById(R.id.button4);
        Intent start_serv = new Intent(getContext(), MyService.class);
        Intent stop_serv = new Intent(getContext(), MyService.class);

        play.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                System.out.println(valueFromSpinner);
                start_serv.putExtra("extrastring", valueFromSpinner);
                System.out.println("in fragment"+valueFromSpinner);
                getContext().startForegroundService(start_serv);

            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                getContext().stopService(stop_serv);

            }

        });

        return view;
    }

       @Override
       public void onItemSelected (AdapterView < ? > parent, View view,int position, long id) {
           if (parent.getId() == R.id.spinner2) {
                valueFromSpinner = parent.getItemAtPosition(position).toString();
               Toast.makeText(parent.getContext(), "Selected: " + valueFromSpinner, Toast.LENGTH_LONG).show();
           }
       }
       @Override
      public void onNothingSelected (AdapterView < ? > parent){


       }






}