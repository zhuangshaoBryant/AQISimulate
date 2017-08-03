package com.zhuang.jackyli.aqysimulate;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.qiyi.net.HttpManager;
import org.qiyi.net.convert.gson.GsonConvertFactory;

import java.util.List;

/**
 * Created by jackyli on 2017/7/26.
 */

public class MyApplication extends Application{
    private static final String TAG = "MyApplication";
    private  static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Fresco.initialize(mContext);
        initNetWorkLib(mContext);
    }

    public static Context getInstance(){
        return mContext;
    }

    /**
     * 初始化网络库环境
     */
    protected void initNetWorkLib(Context mContext) {
        //初始化Networklib库
       // HttpLog.setDebug(DebugLog.DEBUG_LOG_SWITCH);   //是否打开日志
        // 构造Builder对象
        final HttpManager.Builder mBuilder = new HttpManager.Builder()
                .cacheDir(mContext.getDir("qiyi_http_cache", 0));   //设置缓存目录
        int cpuNum = getCPUCount();
        Log.d(TAG, "initNetWorkLib: cpuNum"+cpuNum);
        Log.d(TAG, "initNetWorkLib: mprocessname"+getProcessName(mContext));
        //设置线程池
        if (TextUtils.equals(getProcessName(mContext), mContext.getPackageName())) {
            //网络线程池核心线程数和最大线程数
            mBuilder.netThreadPoolSize(cpuNum, cpuNum * 8)
                    //pingback线程池核心线程和最大线程数
                    .pingbackThreadPoolSize(cpuNum, 2 * cpuNum);
        } else {
            mBuilder.netThreadPoolSize(2, 4)
                    .pingbackThreadPoolSize(2, 4);
        }
        //设置gson解析工厂
        mBuilder.addConvertFactory(GsonConvertFactory.create(initGson()));
        //初始化Networklib(必须调用)
        HttpManager.getInstance().initHttpEnvironment(mContext, mBuilder);
    }

    /**
     * 获取cpu个数
     */
    private int getCPUCount() {
        int num = Runtime.getRuntime().availableProcessors();
        if (num < 2) {
            num = 2;
        }
        if (num > 4) {
            num = 4;
        }
        //DebugLog.d(TAG, "cup count:" + num);
        return num;
    }

    public static String getProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infos = manager.getRunningAppProcesses();
        if (infos != null) {
            for (ActivityManager.RunningAppProcessInfo processInfo : infos) {
                if (processInfo.pid == pid) {
                    return processInfo.processName;
                }
            }
        }
        return null;
    }

    private Gson initGson() {
        GsonBuilder builder = new GsonBuilder();
        //TODO 这里可以设置自定义TypeAdapter
        return builder.create();
    }

}
