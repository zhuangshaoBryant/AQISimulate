package com.zhuang.jackyli.aqysimulate.util;

import android.content.Context;
import android.icu.text.IDNA;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by jackyli on 2017/8/1.
 */

public class ResponseCall<T> {
    Handler mHandler;//用于主线程与子线程切换

    public ResponseCall(Context context,final HttpCallbackModelListener listener){
        Looper looper = context.getMainLooper();
        mHandler = new Handler(looper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0){
                    //成功
                    listener.onFinish(msg.obj.toString());
                }else if (msg.what==1){
                    //失败
                    listener.onError((Exception) msg.obj);
                }
            }
        };
    }

    public ResponseCall(Context context,final HttpCallbackStringListener listener){
        Looper looper = context.getMainLooper();
        mHandler = new Handler(looper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0){
                    //成功
                    listener.onFinish(msg.obj.toString());
                }else if (msg.what==1){
                    //失败
                    listener.onError((Exception) msg.obj);
                }
            }
        };
    }

    public ResponseCall(Context context,final HttpCallbackBytesListener listener){
        Looper looper = context.getMainLooper();
        mHandler = new Handler(looper){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0){
                    //成功
                    listener.onFinish((byte[]) msg.obj);
                }else if (msg.what==1){
                    //失败
                    listener.onError((Exception) msg.obj);
                }
            }
        };
    }

    public void doSuccess(T response){
        Message message = Message.obtain();
        message.what = 0;
        message.obj = response;
        mHandler.sendMessage(message);
    }

    public void doFail(Exception e){
        Message message = Message.obtain();
        message.what = 1;
        message.obj = e;
        mHandler.sendMessage(message);
    }
}
