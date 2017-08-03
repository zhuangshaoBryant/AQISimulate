package com.zhuang.jackyli.aqysimulate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.zhuang.jackyli.aqysimulate.bean.Page;
import com.zhuang.jackyli.aqysimulate.util.HttpCallbackBytesListener;
import com.zhuang.jackyli.aqysimulate.util.HttpCallbackStringListener;
import com.zhuang.jackyli.aqysimulate.util.HttpUtil;
import com.zhuang.jackyli.aqysimulate.util.JsonParseUtil;

import org.json.JSONException;
import org.qiyi.net.Request;
import org.qiyi.net.callback.IHttpCallback;
import org.qiyi.net.exception.HttpException;

import java.util.HashMap;
import java.util.Map;


public class Main2Activity extends AppCompatActivity {
    public static final String TAG = "Main2Activity";
    public static final String houZhui =  "&lang=zh_CN&app_lm=cn&app_k=69842642483add0a63503306d63f0443&app_v=8.7.0&platform_id=10&dev_os=6.0&dev_ua=Letv+X501&net_sts=1&qyid=868897027729508&cupid_v=3.12.002&psp_uid=&psp_cki=&imei=8ccb76b87ea414af2789417782abd2ce&aid=fd8311dd1612d8ee&mac=84:73:03:F4:29:BA&scrn_scale=3&secure_p=GPhone&secure_v=1&core=5&profile=%7B%22group%22%3A%221%2C2%22%2C%22counter%22%3A1%7D&province_id=2008&service_filter=&service_sort=&layout_v=9.0.1501657314&cupid_uid=868897027729508&api_v=5.4&psp_status=1&gps=,&req_times=0&req_sn=1501731496409";
    public static final String url = "http://cards.iqiyi.com/views_home/3.0/qy_home?page_st=&card_v=3.0&lang=zh_CN&app_lm=cn&from_rpage=home_top_menu&from_block=E:020000&from_rseat=0&app_k=69842642483add0a63503306d63f0443&app_v=8.7.0&platform_id=10&dev_os=6.0&dev_ua=Letv+X501&net_sts=1&qyid=868897027729508&cupid_v=3.12.002&psp_uid=&psp_cki=&imei=8ccb76b87ea414af2789417782abd2ce&aid=fd8311dd1612d8ee&mac=84:73:03:F4:29:BA&scrn_scale=3&secure_p=GPhone&secure_v=1&core=5&profile=%7B%22group%22%3A%221%2C2%22%2C%22counter%22%3A1%7D&province_id=2008&service_filter=&service_sort=&layout_v=9.0.1501657314&cupid_uid=868897027729508&api_v=5.4&psp_status=1&gps=,&req_times=0&req_sn=1501728947035";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final LinearLayout layout = (LinearLayout) findViewById(R.id.line1);
        final Button button = (Button) findViewById(R.id.button);
        /*final Map<String,Object> map = new HashMap<String, Object>();
        map.put("q","AndroidStudio安装json转javabean对象的插件");*/
        //参数列表
        final Map<String, Object> map = new HashMap<>();
        //map.put("menu", "土豆");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HttpUtil.doGet(Main2Activity.this, url, new HttpCallbackStringListener() {
                    @Override
                    public void onFinish(String response) {
                        Log.d(TAG, "onFinish: response111"+response);
                        /*Gson gson = new Gson();
                        Page page = gson.fromJson(response, Page.class);
                        Log.d(TAG, "Page: "+page.getCards().get(0).getBlocks().get(0).getMetas().get(1).getText());*/
                        //button.setText(response);
                        try {
                            JsonParseUtil.parseJson(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
            }
        });
        /*Request<String> mRequest = new Request.Builder<String>()
                .url(url)
                .build(String.class);

        mRequest.sendRequest(new IHttpCallback<String>() {
            @Override
            public void onResponse(String s) {
                Log.d(TAG, "onResponse: "+s);
            }

            @Override
            public void onErrorResponse(HttpException e) {

            }
        });*/



    }



}
