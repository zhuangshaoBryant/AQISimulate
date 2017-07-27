package com.zhuang.jackyli.aqysimulate.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jackyli on 2017/7/24.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;  //fragment集合
    private List<String>  titles; //标题集合

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {

        int ret = 0;
        if(fragments!=null && fragments.size()!=0){
            ret = fragments.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
