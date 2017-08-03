package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackyli on 2017/8/2.
 */

public class Block implements Serializable {
    private static final long serialVersionUID = 1l;

    public List<Image> images;
    public List<Meta> metas; //标题1,2


    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }
}
