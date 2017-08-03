package com.zhuang.jackyli.aqysimulate.bean;

import java.io.Serializable;

/**
 * Created by jackyli on 2017/8/2.
 */

public class Image implements Serializable {
    private static final long serialVersionUID = 1l;
    public String url;//大图片的url
    public Mark marks;

    public Mark getMarks() {
        return marks;
    }

    public void setMarks(Mark marks) {
        this.marks = marks;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class Mark {
        public RdMark rd_mark;
        public LdMark ld_mark;

        public LdMark getLd_mark() {
            return ld_mark;
        }

        public void setLd_mark(LdMark ld_mark) {
            this.ld_mark = ld_mark;
        }

        public RdMark getRd_mark() {
            return rd_mark;
        }

        public void setRd_mark(RdMark rd_mark) {
            this.rd_mark = rd_mark;
        }

        public static class RdMark {
            public String t; // 图片上右下角text

            public String getT() {
                return t;
            }

            public void setT(String t) {
                this.t = t;
            }
        }

        public static class LdMark {
            public String t;//图片左下角text

            public String getT() {
                return t;
            }

            public void setT(String t) {
                this.t = t;
            }
        }
    }
}
