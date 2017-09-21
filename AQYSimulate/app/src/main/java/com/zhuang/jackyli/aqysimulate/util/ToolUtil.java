package com.zhuang.jackyli.aqysimulate.util;

import android.app.WallpaperInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.webkit.ServiceWorkerClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by jackyli on 2017/9/20.
 */

public class ToolUtil {

    public static String RELATIVELAYOUT = "RelativeLayout";
    public static String LINEARLAYOUT = "LinearLayout";

    /**
     * dp转为px
     * @param context  上下文
     * @param dipValue dp值
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        Resources r = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dipValue, r.getDisplayMetrics());
    }

}
