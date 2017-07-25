package com.zhuang.jackyli.aqysimulate.model;

/**
 * Created by jackyli on 2017/7/25.
 */

public class Model2 {
    private String leftIconImageviewUrl; //左小图的网址
    private String textTextview; //左大标题
    private String rightTextview; //右小标题

    public Model2(String leftIconImageviewUrl, String textTextview, String rightTextview) {
        this.leftIconImageviewUrl = leftIconImageviewUrl;
        this.textTextview = textTextview;
        this.rightTextview = rightTextview;
    }

    public String getLeftIconImageviewUrl() {
        return leftIconImageviewUrl;
    }

    public void setLeftIconImageviewUrl(String leftIconImageviewUrl) {
        this.leftIconImageviewUrl = leftIconImageviewUrl;
    }

    public String getTextTextview() {
        return textTextview;
    }

    public void setTextTextview(String textTextview) {
        this.textTextview = textTextview;
    }

    public String getRightTextview() {
        return rightTextview;
    }

    public void setRightTextview(String rightTextview) {
        this.rightTextview = rightTextview;
    }
}
