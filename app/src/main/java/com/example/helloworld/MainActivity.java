package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.net.wifi.WifiManager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabItem AP,Train,Locateme,chart;
    ViewPager viewPager;
    Adapterfortab pageadapter;
    TabLayout tabLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout1=(TabLayout)findViewById(R.id.tablayout1);
        AP=(TabItem)findViewById(R.id.tab1);
        Train=(TabItem)findViewById(R.id.tab2);
        Locateme=(TabItem)findViewById(R.id.tab3);
        chart=(TabItem)findViewById(R.id.tab4);
        viewPager=(ViewPager)findViewById(R.id.vpager);

        pageadapter=new Adapterfortab(getSupportFragmentManager(),tabLayout1.getTabCount());
        viewPager.setAdapter(pageadapter);

        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2||tab.getPosition()==3)
                    pageadapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        //listen for scroll or page change
    }
}


