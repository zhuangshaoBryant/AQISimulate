package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;

/**
 * Created by jackyli on 2017/8/2.
 */

public class Meta implements Serializable {
    private static final long serialVersionUID = 1l;
    public String text;//下标题

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
