package com.zhuang.jackyli.aqysimulate;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by jackyli on 2017/7/26.
 */

public class MyApplication extends Application{
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Fresco.initialize(mContext);
    }

    public static Context getInstance(){
        return mContext;
    }
}
