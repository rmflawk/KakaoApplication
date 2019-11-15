package com.youngstudio.kakaoapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainAdapter extends FragmentPagerAdapter {

    Fragment[] fragments= new Fragment[4];


    public MainAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
        fragments[0]= new MainFragment();
        fragments[1]= new KategorieFragment();
        fragments[2]= new ChattingFragment();
        fragments[3]= new MyPageFragment();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }




}
