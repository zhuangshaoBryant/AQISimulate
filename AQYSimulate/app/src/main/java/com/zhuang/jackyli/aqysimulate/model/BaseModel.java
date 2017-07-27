package com.zhuang.jackyli.aqysimulate.model;

/**
 * Created by jackyli on 2017/7/26.
 */

public class BaseModel {
    private String firstPic;//第一个图url
    private String secondPic;//第二个图的url

    private String firstText;//第一个文字
    private String secondText;//第二个文字
    private String thirdText;//第三个文字
    private String fourText;//第四个文字


    public BaseModel(String firstPic, String secondPic, String firstText, String secondText, String thirdText, String fourText) {
        this.firstPic = firstPic;
        this.secondPic = secondPic;
        this.firstText = firstText;
        this.secondText = secondText;
        this.thirdText = thirdText;
        this.fourText = fourText;
    }

    public String getFirstPic() {
        return firstPic;
    }

    public void setFirstPic(String firstPic) {
        this.firstPic = firstPic;
    }

    public String getSecondPic() {
        return secondPic;
    }

    public void setSecondPic(String secondPic) {
        this.secondPic = secondPic;
    }

    public String getFourText() {
        return fourText;
    }

    public void setFourText(String fourText) {
        this.fourText = fourText;
    }

    public String getThirdText() {
        return thirdText;
    }

    public void setThirdText(String thirdText) {
        this.thirdText = thirdText;
    }

    public String getFirstText() {
        return firstText;
    }

    public void setFirstText(String firstText) {
        this.firstText = firstText;
    }

    public String getSecondText() {
        return secondText;
    }

    public void setSecondText(String secondText) {
        this.secondText = secondText;
    }
}
