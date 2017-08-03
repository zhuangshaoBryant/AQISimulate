package com.zhuang.jackyli.aqysimulate.bean;

import android.widget.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackyli on 2017/8/2.
 */

public class BottomBanner implements Serializable {
    private static final long serialVersionUID = 1l;
    public List<BottomBlock> blocks;

    public List<BottomBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<BottomBlock> blocks) {
        this.blocks = blocks;
    }

    public static class BottomBlock {
        public int block_type; //类型为102，为type类型的578，根据buttons的size决定
        public List<Button> buttons;

        public int getBlock_type() {
            return block_type;
        }

        public void setBlock_type(int block_type) {
            this.block_type = block_type;
        }

        public List<Button> getButtons() {
            return buttons;
        }

        public void setButtons(List<Button> buttons) {
            this.buttons = buttons;
        }
    }

}
