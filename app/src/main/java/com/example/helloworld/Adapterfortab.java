package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapterfortab  extends FragmentPagerAdapter {
    int tabcount;

    public Adapterfortab(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return new Fragmentwifi();
            case 1 : return new Fragmenttrain();
            case 2 : return new Fragmentlocate();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

