package com.zhuang.jackyli.aqysimulate.util;

/**
 * Created by jackyli on 2017/8/1.
 */

public interface HttpCallbackModelListener<T> {
    void onFinish(T response);
    void onError(Exception e);
}
