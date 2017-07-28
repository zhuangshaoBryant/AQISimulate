package com.zhuang.jackyli.aqysimulate.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.ui.MyCycleViewPager;

import java.util.List;

/**
 * Created by jackyli on 2017/7/28.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> views;

    public MyPagerAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int index = innerPosition(position);
        if(views.get(index).getParent()!=null){
            container.removeView(views.get(index));
        }
        container.addView(views.get(index));
        Log.d("weizhi", "instantiateItem: "+position);
        return views.get(index);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int index = innerPosition(position);
        Log.d("weizhi", "destroyItem: "+position);
        container.removeView(views.get(index));
    }

    private int innerPosition(int position) {
        return position % views.size();
    }
}
