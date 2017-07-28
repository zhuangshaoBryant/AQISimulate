package com.zhuang.jackyli.aqysimulate.data;

import com.zhuang.jackyli.aqysimulate.model.BaseModel;
import com.zhuang.jackyli.aqysimulate.model.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackyli on 2017/7/27.
 */

public class ViewModelData {
    String HorizontalBigPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/6.png"; //横图1
    String HorizontalBigPic2 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/7.jpg";//横图2
    String smallPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/8.png";//小图标
    String verticalPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/9.jpg";//竖图
    String smallPic2 =  "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/10.png";//1080p小图
    String dongPic =  "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/12.gif";//动图gif
    //四个轮播图
    String lunboPic1 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/13.jpg";//轮播图1
    String lunboPic2 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/14.jpg";//轮播图2
    String lunboPic3 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/15.jpg";//轮播图3
    String lunboPic4 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/16.jpg";//轮播图4

    /**
     * type1+type2+3个type3+type7
     *
     * @return
     */
    public List<ViewModel> addCard1() {
        List<ViewModel> list = new ArrayList<>();
        //添加type1
        list.add(new ViewModel(1));
        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(smallPic, null, "Card1综艺", "中国有嘻哈投票", null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type3
        for (int i = 0; i < 3; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(HorizontalBigPic, smallPic2, "大标题", "小标题", "14:sim", "2017/7/26");
            BaseModel middle = new BaseModel(HorizontalBigPic2, smallPic2, "大标题2", "小标题2", "14:13", "2017/7/27");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            ViewModel model346 = new ViewModel(baseModel3461s, 3);
            list.add(model346);
        }
        //添加type7
        List<BaseModel> baseMode7s = new ArrayList<>();
        BaseModel baseMode7 = new BaseModel(smallPic, null, "查看更多内容", null, null, null);
        BaseModel baseMode72 = new BaseModel(smallPic, null, "换一批", null, null, null);
        baseMode7s.add(baseMode7);
        baseMode7s.add(baseMode72);
        list.add(new ViewModel(baseMode7s, 7));
        return list;
    }

    /**
     * type1+type2+2个type4+type5
     *
     * @return
     */
    public List<ViewModel> addCard2() {
        List<ViewModel> list = new ArrayList<>();
        //添加type1
        list.add(new ViewModel(1));
        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(smallPic, null, "Card2电影", "躁动青春燃情记忆", null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type3
        for (int i = 0; i < 2; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(verticalPic, smallPic2, "大标题", "小标题", "14:sim", "2017/7/26");
            BaseModel middle = new BaseModel(verticalPic, smallPic2, "大标题2", "小标题2", "14:13", "2017/7/27");
            BaseModel right = new BaseModel(verticalPic, smallPic2, "大标题3", "小标题3", "14:13", "2017/7/27");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            baseModel3461s.add(right);
            ViewModel model346 = new ViewModel(baseModel3461s, 4);
            list.add(model346);
        }
        //添加type5
        List<BaseModel> baseMode7s = new ArrayList<>();
        BaseModel baseMode7 = new BaseModel(smallPic, null, "查看更多内容", null, null, null);
        baseMode7s.add(baseMode7);
        list.add(new ViewModel(baseMode7s, 5));
        return list;
    }

    /**
     * type1+type2+1个type4+type5
     *
     * @return
     */
    public List<ViewModel> addCard3() {
        List<ViewModel> list = new ArrayList<>();
        //添加type1
        list.add(new ViewModel(1));
        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(smallPic, null, "Card3奇秀直播", "更多美女", null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type3
        for (int i = 0; i < 1; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(verticalPic, smallPic2, "大标题", "小标题", "14:sim", "2017/7/26");
            BaseModel middle = new BaseModel(verticalPic, smallPic2, "大标题2", "小标题2", "14:13", "2017/7/27");
            BaseModel right = new BaseModel(verticalPic, smallPic2, "大标题3", "小标题3", "14:13", "2017/7/27");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            baseModel3461s.add(right);
            ViewModel model346 = new ViewModel(baseModel3461s, 4);
            list.add(model346);
        }
        //添加type5
        List<BaseModel> baseMode7s = new ArrayList<>();
        BaseModel baseMode7 = new BaseModel(smallPic, null, "查看更多内容", null, null, null);
        baseMode7s.add(baseMode7);
        list.add(new ViewModel(baseMode7s, 5));
        return list;
    }

    /**
     * type1+type2+1个type6+1type3
     *
     * @return
     */
    public List<ViewModel> addCard4() {
        List<ViewModel> list = new ArrayList<>();
        //添加type1
        list.add(new ViewModel(1));
        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(smallPic, null, "Card4爱奇艺7月热播", null, null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type6
        List<BaseModel> baseModel6s = new ArrayList<>();
        BaseModel baseModel6 = new BaseModel(HorizontalBigPic2, smallPic2, "中国新歌声独家专访", "腼腆boy扎西哈哈哈哈哈哈哈阿哈哈哈哈哈", null, null);
        baseModel6s.add(baseModel6);
        list.add(new ViewModel(baseModel6s, 6));
        //添加type3
        for (int i = 0; i < 1; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(dongPic, smallPic2, "大标题", "小标题", "14:sim", "2017/7/26");
            BaseModel middle = new BaseModel(HorizontalBigPic2, smallPic2, "大标题2", "小标题2", "14:13", "2017/7/27");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            ViewModel model346 = new ViewModel(baseModel3461s, 3);
            list.add(model346);
        }
        return list;
    }

    /**
     * type1+type2+2个type4+type8
     *
     * @return
     */
    public List<ViewModel> addCard5() {
        List<ViewModel> list = new ArrayList<>();
        //添加type1
        list.add(new ViewModel(1));
        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(smallPic, null, "Card5动漫", "名侦探柯南", null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type3
        for (int i = 0; i < 2; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(verticalPic, smallPic2, "大标题", null, null, "12集全");
            BaseModel middle = new BaseModel(verticalPic, smallPic2, "大标题2", null, null, "24集全");
            BaseModel right = new BaseModel(verticalPic, smallPic2, "大标题3", null, null, "36集全");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            baseModel3461s.add(right);
            ViewModel model346 = new ViewModel(baseModel3461s, 4);
            list.add(model346);
        }
        //添加type8
        List<BaseModel> baseMode7s = new ArrayList<>();
        BaseModel baseMode7 = new BaseModel(smallPic, null, "更多资讯", null, null, null);
        BaseModel baseMode72 = new BaseModel(smallPic, null, "上海热点", null, null, null);
        BaseModel baseMode73 = new BaseModel(smallPic, null, "换一批", null, null, null);
        baseMode7s.add(baseMode7);
        baseMode7s.add(baseMode72);
        baseMode7s.add(baseMode73);
        list.add(new ViewModel(baseMode7s, 8));
        return list;
    }
    /**
     * 轮播图
     *
     * @return
     */
    public List<ViewModel> addCard6() {
        List<ViewModel> list = new ArrayList<>();
        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(smallPic, null, "Card6推荐", "名侦探柯南", null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type3
        for (int i = 0; i < 1; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(lunboPic1, smallPic2, null, null, "楚乔传：哇哈哈相爱相杀", "07-27期");
            BaseModel middle = new BaseModel(lunboPic2, smallPic2,  null, null, "大标题2","24集全");
            BaseModel right = new BaseModel(lunboPic3, smallPic2,  null, null, "大标题3","36集全");
            BaseModel right1 = new BaseModel(lunboPic4, smallPic2,  null, null, "大标题3","36集全");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            baseModel3461s.add(right);
            baseModel3461s.add(right1);
            ViewModel model346 = new ViewModel(baseModel3461s, 9);
            list.add(model346);
        }
        return list;
    }
}
