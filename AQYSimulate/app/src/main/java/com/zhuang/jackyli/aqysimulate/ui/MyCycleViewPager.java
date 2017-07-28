package com.zhuang.jackyli.aqysimulate.ui;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by jackyli on 2017/7/28.
 */

public class MyCycleViewPager extends ViewPager{
    public ViewGroup parent;
    public MyCycleViewPager(Context context) {
        super(context);
    }

    public MyCycleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setParent(ViewGroup parent) {
        this.parent = parent;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(parent !=null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        if(parent !=null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(parent !=null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(ev);
    }

}
