package com.ibtech.smg.android_benchmark;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.CarouselOneFragment;
import layout.CarouselThreeFragment;
import layout.CarouselTwoFragment;

public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CarouselOneFragment();
        } else if(position == 1){
            return new CarouselTwoFragment();
        } else {
            return new CarouselThreeFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
