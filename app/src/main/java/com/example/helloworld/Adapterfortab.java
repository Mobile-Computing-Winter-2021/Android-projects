package com.example.helloworld;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapterfortab  extends FragmentPagerAdapter {
    int count;

    public Adapterfortab(@NonNull FragmentManager fragment, int behavior) {
        super(fragment, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int pos)
    {
        switch (pos)
        {
            case 0 : return new Fragmentwifi();
            case 1:  return new Fragmentchart();
            case 2 : return new Fragmenttrain();
            case 3 : return new Fragmentlocate();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}

