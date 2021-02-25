package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity
{
    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransact;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentmanager = getSupportFragmentManager();
        fragmenttransact = fragmentmanager.beginTransaction();
        Fragment1 student1 = new Fragment1();
        fragmenttransact.add(R.id.container1,student1 );
        //fragmentTransaction.addToBackStack(null);
        fragmenttransact.commit();

    }
   // public void onResume{
   // youradapter.refreshrecyclerview(); // implement this method in adpater or simply call here
    //adpater.notifiDataSetChanged();
//}
}