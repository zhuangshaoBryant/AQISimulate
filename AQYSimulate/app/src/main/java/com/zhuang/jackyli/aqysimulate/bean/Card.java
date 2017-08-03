package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackyli on 2017/8/2.
 */

public class Card implements Serializable {
    private static final long serialVersionUID = 1l;

    //card类型为card_r1_cN_focus，表示焦点图
    //card_rN_c2表示横排两个
    //card_rN_c1_2_base表示上面一个大图，下面两个小图
    //card_r1_c1_btmargin0表示信息流广告大图
    public String card_class;
    public List<Block> blocks;
    public TopBanner top_banner;
    public BottomBanner bottom_banner;

    public BottomBanner getBottom_banner() {
        return bottom_banner;
    }

    public void setBottom_banner(BottomBanner bottom_banner) {
        this.bottom_banner = bottom_banner;
    }

    public TopBanner getTop_banner() {
        return top_banner;
    }

    public void setTop_banner(TopBanner top_banner) {
        this.top_banner = top_banner;
    }

    public String getCard_class() {
        return card_class;
    }

    public void setCard_class(String card_class) {
        this.card_class = card_class;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
