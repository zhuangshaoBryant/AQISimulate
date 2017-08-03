package com.zhuang.jackyli.aqysimulate.util;

/**
 * Created by jackyli on 2017/8/1.
 */

public interface HttpCallbackStringListener {
    void onFinish(String response);
    void onError(Exception e);
}
