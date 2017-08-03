package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackyli on 2017/8/2.
 */

public class TopBanner implements Serializable {
    private static final long serialVersionUID = 1l;
    public List<L_Block> l_blocks;

    public List<L_Block> getL_blocks() {
        return l_blocks;
    }

    public void setL_blocks(List<L_Block> l_blocks) {
        this.l_blocks = l_blocks;
    }

    public static class L_Block{
        public int block_type;//类型，如果为23，则为type2
        public List<Meta> metas;  //type2上大标题
        public List<Image> images;
        public List<Button> buttons; //type2上小标题

        public int getBlock_type() {
            return block_type;
        }

        public void setBlock_type(int block_type) {
            this.block_type = block_type;
        }

        public List<Meta> getMetas() {
            return metas;
        }

        public void setMetas(List<Meta> metas) {
            this.metas = metas;
        }

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public List<Button> getButtons() {
            return buttons;
        }

        public void setButtons(List<Button> buttons) {
            this.buttons = buttons;
        }
    }

}
