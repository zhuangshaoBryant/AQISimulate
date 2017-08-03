package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;

/**
 * Created by jackyli on 2017/8/2.
 */

public class PageBase implements Serializable{
    private static final long serialVersionUID = 1l;

    public String next_url;//下一页的加载地址,如果为null，说明加载完毕

    public String getNext_url() {
        return next_url;
    }

    public void setNext_url(String next_url) {
        this.next_url = next_url;
    }
}
