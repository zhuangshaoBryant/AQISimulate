package com.zhuang.jackyli.aqysimulate.data;

import android.util.Log;

import com.zhuang.jackyli.aqysimulate.bean.Block;
import com.zhuang.jackyli.aqysimulate.bean.Card;
import com.zhuang.jackyli.aqysimulate.bean.TopBanner;
import com.zhuang.jackyli.aqysimulate.constant.Constant;
import com.zhuang.jackyli.aqysimulate.model.BaseModel;
import com.zhuang.jackyli.aqysimulate.model.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackyli on 2017/7/27.
 */

public class ViewModelData {

    /**
     * 将Card数据转换为List<ViewModel></>
     * @param card
     * @return
     */
    public static List<ViewModel> getData(Card card) {
        List<ViewModel> viewModelList = new ArrayList<>();

        //type9，焦点图
        if (card.getCard_class().equals("card_r1_cN_focus")) {
            List<BaseModel> baseModels = new ArrayList<>();
            List<Block> blocks = card.getBlocks();
            for (int i = 0; i < blocks.size(); i++) {
                Block block = blocks.get(i);
                String firstPic = block.getImages().get(0).getUrl();
                String thirdText = block.getMetas().get(0).getText();
                String fourText = block.getMetas().get(1).getText();
                BaseModel baseModel = new BaseModel(firstPic, Constant.SECONT_PIC, null, null, thirdText, fourText);
                baseModels.add(baseModel);
            }
            ViewModel viewModel = new ViewModel(baseModels, 9);
            viewModelList.add(viewModel);
            //添加type1
            viewModelList.add(new ViewModel(1));
            Log.d("wwww", "first    size: " + viewModelList.size());
        }

        //type3、type2、type578,添加两列的数据
        if (card.getCard_class().equals("card_rN_c2")) {
            //type2获取,存在TopBanner并且l_blocks的block_type为23时
            if (card.getTop_banner() != null && card.getTop_banner().getL_blocks().get(0).getBlock_type() == 23) {
                TopBanner topBanner = card.getTop_banner();
                List<BaseModel> baseModels = new ArrayList<>();
                String firstPic = topBanner.getL_blocks().get(0).getImages().get(0).getUrl();
                String firstText = topBanner.getL_blocks().get(0).getMetas().size() > 0 ? topBanner.getL_blocks().get(0).getMetas().get(0).getText() : null;
                String secondText = topBanner.getL_blocks().get(0).getButtons().size() > 0 ? topBanner.getL_blocks().get(0).getButtons().get(0).getText() : null;
                BaseModel baseModel = new BaseModel(firstPic, null, firstText, secondText, null, null);
                baseModels.add(baseModel);
                viewModelList.add(new ViewModel(baseModels, 2));
            }
            //type3获取，最多不超过三行
            if (card.getBlocks() != null) {
                List<Block> blocks = card.getBlocks();
                int lines = getLinesFor2(blocks.size());//type3有几行
                for (int i = 0; i < lines; i++) {
                    List<BaseModel> baseModels = new ArrayList<>();
                    int left = 2 * i;//左图位置
                    int right = 2 * i + 1;
                    Block leftBlock = blocks.get(left);
                    Block rightBlock = blocks.get(right);
                    BaseModel leftBaseModel = new BaseModel(leftBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            leftBlock.getMetas().size() > 0 ? leftBlock.getMetas().get(0).getText() : null,
                            leftBlock.getMetas().size() > 1 ? leftBlock.getMetas().get(1).getText() : null,
                            (leftBlock.getImages().get(0).getMarks() != null && leftBlock.getImages().get(0).getMarks().getLd_mark() != null) ? leftBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (leftBlock.getImages().get(0).getMarks() != null && leftBlock.getImages().get(0).getMarks().getRd_mark() != null) ? leftBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    BaseModel rightBaseModel = new BaseModel(rightBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            rightBlock.getMetas().size() > 0 ? rightBlock.getMetas().get(0).getText() : null,
                            rightBlock.getMetas().size() > 1 ? rightBlock.getMetas().get(1).getText() : null,
                            (rightBlock.getImages().get(0).getMarks() != null && rightBlock.getImages().get(0).getMarks().getLd_mark() != null) ? rightBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (rightBlock.getImages().get(0).getMarks() != null && rightBlock.getImages().get(0).getMarks().getRd_mark() != null) ? rightBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    baseModels.add(leftBaseModel);
                    baseModels.add(rightBaseModel);
                    viewModelList.add(new ViewModel(baseModels, 3));
                }
            }
            //type578获取，
            if (card.getBottom_banner() != null && card.getBottom_banner().getBlocks().get(0).getBlock_type() == 102) {
                switch (card.getBottom_banner().getBlocks().get(0).getButtons().size()) {
                    case 1:
                        List<BaseModel> baseModels = new ArrayList<>();
                        BaseModel baseModel = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(0).getText(), null, null, null);
                        baseModels.add(baseModel);
                        viewModelList.add(new ViewModel(baseModels, 5));
                        break;
                    case 2:
                        List<BaseModel> baseModels2 = new ArrayList<>();
                        BaseModel baseModel2 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(0).getText(),
                                null, null, null);
                        BaseModel baseModel22 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(1).getText(),
                                null, null, null);
                        baseModels2.add(baseModel2);
                        baseModels2.add(baseModel22);
                        viewModelList.add(new ViewModel(baseModels2, 7));
                        break;
                    case 3:
                        List<BaseModel> baseModels23 = new ArrayList<>();
                        BaseModel baseModel23 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(0).getText(),
                                null, null, null);
                        BaseModel baseModel231 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(1).getText(),
                                null, null, null);
                        BaseModel baseModel232 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(2).getText(),
                                null, null, null);
                        baseModels23.add(baseModel23);
                        baseModels23.add(baseModel231);
                        baseModels23.add(baseModel232);
                        viewModelList.add(new ViewModel(baseModels23, 8));
                        break;
                    default:
                }
            }
            viewModelList.add(new ViewModel(1));
        }

        //type4、type2、type578,添加3列的数据
        if (card.getCard_class().equals("card_rN_c3")) {
            //type2获取,存在TopBanner并且l_blocks的block_type为23时
            if (card.getTop_banner() != null && card.getTop_banner().getL_blocks().get(0).getBlock_type() == 23) {
                TopBanner topBanner = card.getTop_banner();
                List<BaseModel> baseModels = new ArrayList<>();
                String firstPic = topBanner.getL_blocks().get(0).getImages().get(0).getUrl();
                String firstText = topBanner.getL_blocks().get(0).getMetas().size() > 0 ? topBanner.getL_blocks().get(0).getMetas().get(0).getText() : null;
                String secondText = topBanner.getL_blocks().get(0).getButtons().size() > 0 ? topBanner.getL_blocks().get(0).getButtons().get(0).getText() : null;
                BaseModel baseModel = new BaseModel(firstPic, null, firstText, secondText, null, null);
                baseModels.add(baseModel);
                viewModelList.add(new ViewModel(baseModels, 2));
            }
            //type4获取，最多不超过三行
            if (card.getBlocks() != null) {
                List<Block> blocks = card.getBlocks();
                int lines = getLinesFor3(blocks.size());//type4有几行
                for (int i = 0; i < lines; i++) {
                    List<BaseModel> baseModels = new ArrayList<>();
                    int left = 3 * i;//左图位置
                    int middle = 3 * i + 1;
                    int right = 3 * i + 2;
                    Block leftBlock = blocks.get(left);
                    Block middleBlock = blocks.get(middle);
                    Block rightBlock = blocks.get(right);
                    BaseModel leftBaseModel = new BaseModel(leftBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            leftBlock.getMetas().size() > 0 ? leftBlock.getMetas().get(0).getText() : null,
                            leftBlock.getMetas().size() > 1 ? leftBlock.getMetas().get(1).getText() : null,
                            (leftBlock.getImages().get(0).getMarks() != null && leftBlock.getImages().get(0).getMarks().getLd_mark() != null) ? leftBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (leftBlock.getImages().get(0).getMarks() != null && leftBlock.getImages().get(0).getMarks().getRd_mark() != null) ? leftBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    BaseModel middleBaseModel = new BaseModel(middleBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            middleBlock.getMetas().size() > 0 ? middleBlock.getMetas().get(0).getText() : null,
                            middleBlock.getMetas().size() > 1 ? middleBlock.getMetas().get(1).getText() : null,
                            (middleBlock.getImages().get(0).getMarks() != null && middleBlock.getImages().get(0).getMarks().getLd_mark() != null) ? middleBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (middleBlock.getImages().get(0).getMarks() != null && middleBlock.getImages().get(0).getMarks().getRd_mark() != null) ? middleBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    BaseModel rightBaseModel = new BaseModel(rightBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            rightBlock.getMetas().size() > 0 ? rightBlock.getMetas().get(0).getText() : null,
                            rightBlock.getMetas().size() > 1 ? rightBlock.getMetas().get(1).getText() : null,
                            (rightBlock.getImages().get(0).getMarks() != null && rightBlock.getImages().get(0).getMarks().getLd_mark() != null) ? rightBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (rightBlock.getImages().get(0).getMarks() != null && rightBlock.getImages().get(0).getMarks().getRd_mark() != null) ? rightBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    baseModels.add(leftBaseModel);
                    baseModels.add(middleBaseModel);
                    baseModels.add(rightBaseModel);
                    viewModelList.add(new ViewModel(baseModels, 4));
                }
            }
            //type578获取，
            if (card.getBottom_banner() != null && card.getBottom_banner().getBlocks().get(0).getBlock_type() == 102) {
                switch (card.getBottom_banner().getBlocks().get(0).getButtons().size()) {
                    case 1:
                        List<BaseModel> baseModels = new ArrayList<>();
                        BaseModel baseModel = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(0).getText(), null, null, null);
                        baseModels.add(baseModel);
                        viewModelList.add(new ViewModel(baseModels, 5));
                        break;
                    case 2:
                        List<BaseModel> baseModels2 = new ArrayList<>();
                        BaseModel baseModel2 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(0).getText(),
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(1).getText(), null, null);
                        BaseModel baseModel22 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(1).getText(),
                                null, null, null);
                        baseModels2.add(baseModel2);
                        baseModels2.add(baseModel22);
                        viewModelList.add(new ViewModel(baseModels2, 7));
                        break;
                    case 3:
                        List<BaseModel> baseModels23 = new ArrayList<>();
                        BaseModel baseModel23 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(0).getText(),
                                null, null, null);
                        BaseModel baseModel233 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(1).getText(),
                                null, null, null);
                        BaseModel baseModel234 = new BaseModel(null, null,
                                card.getBottom_banner().getBlocks().get(0).getButtons().get(2).getText(),
                                null, null, null);
                        baseModels23.add(baseModel23);
                        baseModels23.add(baseModel233);
                        baseModels23.add(baseModel234);
                        viewModelList.add(new ViewModel(baseModels23, 8));
                        break;
                    default:
                }
            }
            viewModelList.add(new ViewModel(1));
        }

        //type6、type2,添加2列的数据
        if (card.getCard_class().equals("card_rN_c1_2_base")) {
            //type2获取,存在TopBanner并且l_blocks的block_type为23时
            if (card.getTop_banner() != null && card.getTop_banner().getL_blocks().get(0).getBlock_type() == 23) {
                TopBanner topBanner = card.getTop_banner();
                List<BaseModel> baseModels = new ArrayList<>();
                String firstText = topBanner.getL_blocks().get(0).getMetas().size() > 0 ? topBanner.getL_blocks().get(0).getMetas().get(0).getText() : null;
                BaseModel baseModel = new BaseModel(null, null, firstText, null, null, null);
                baseModels.add(baseModel);
                viewModelList.add(new ViewModel(baseModels, 2));
            }
            //type6+type2获取，最多不超过三行
            if (card.getBlocks() != null) {
                List<Block> blocks = card.getBlocks();
                //type6添加
                Block block6 = blocks.get(0);
                List<BaseModel> baseModels6 = new ArrayList<>();
                BaseModel baseMode6 = new BaseModel(block6.getImages().get(0).getUrl(),
                        Constant.SECONT_PIC,
                        block6.getMetas().size() > 0 ? block6.getMetas().get(0).getText() : null,
                        block6.getMetas().size() > 1 ? block6.getMetas().get(1).getText() : null,
                        (block6.getImages().get(0).getMarks() != null && block6.getImages().get(0).getMarks().getLd_mark() != null) ? block6.getImages().get(0).getMarks().getLd_mark().getT() : null,
                        (block6.getImages().get(0).getMarks() != null && block6.getImages().get(0).getMarks().getRd_mark() != null) ? block6.getImages().get(0).getMarks().getRd_mark().getT() : null
                );
                baseModels6.add(baseMode6);
                viewModelList.add(new ViewModel(baseModels6, 6));
                //添加type2
                int lines = getLinesFor2(blocks.size() - 1);//type3有几行
                for (int i = 0; i < lines; i++) {
                    List<BaseModel> baseModels = new ArrayList<>();
                    int left = 2 * i + 1;//左图位置
                    int right = 2 * i + 2;
                    Block leftBlock = blocks.get(left);
                    Block rightBlock = blocks.get(right);
                    BaseModel leftBaseModel = new BaseModel(leftBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            leftBlock.getMetas().size() > 0 ? leftBlock.getMetas().get(0).getText() : null,
                            leftBlock.getMetas().size() > 1 ? leftBlock.getMetas().get(1).getText() : null,
                            (leftBlock.getImages().get(0).getMarks() != null && leftBlock.getImages().get(0).getMarks().getLd_mark() != null) ? leftBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (leftBlock.getImages().get(0).getMarks() != null && leftBlock.getImages().get(0).getMarks().getRd_mark() != null) ? leftBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    BaseModel rightBaseModel = new BaseModel(rightBlock.getImages().get(0).getUrl(),
                            Constant.SECONT_PIC,
                            rightBlock.getMetas().size() > 0 ? rightBlock.getMetas().get(0).getText() : null,
                            rightBlock.getMetas().size() > 1 ? rightBlock.getMetas().get(1).getText() : null,
                            (rightBlock.getImages().get(0).getMarks() != null && rightBlock.getImages().get(0).getMarks().getLd_mark() != null) ? rightBlock.getImages().get(0).getMarks().getLd_mark().getT() : null,
                            (rightBlock.getImages().get(0).getMarks() != null && rightBlock.getImages().get(0).getMarks().getRd_mark() != null) ? rightBlock.getImages().get(0).getMarks().getRd_mark().getT() : null
                    );
                    baseModels.add(leftBaseModel);
                    baseModels.add(rightBaseModel);
                    viewModelList.add(new ViewModel(baseModels, 3));
                }
            }
            viewModelList.add(new ViewModel(1));
        }

        //type6、信息流广告图
        if (card.getCard_class().equals("card_r1_c1_btmargin0")) {
            //type6+type2获取，最多不超过三行
            if (card.getBlocks() != null) {
                List<Block> blocks = card.getBlocks();
                if (blocks.size() > 0) {
                    //type6添加
                    Block block6 = blocks.get(0);
                    List<BaseModel> baseModels6 = new ArrayList<>();
                    BaseModel baseMode6 = new BaseModel(block6.getImages().get(0).getUrl(),
                            null,
                            block6.getMetas().size() > 0 ? block6.getMetas().get(0).getText() : null,
                            block6.getMetas().size() > 1 ? block6.getMetas().get(1).getText() : null, null, null);
                    baseModels6.add(baseMode6);
                    viewModelList.add(new ViewModel(baseModels6, 6));
                    viewModelList.add(new ViewModel(1));
                }
            }
        }
        Log.d("wwww", "returnhou : " + viewModelList.size());
        return viewModelList;
    }

    /**
     * 两列的有几行type3
     *
     * @param size
     * @return
     */

    private static int getLinesFor2(int size) {
        if (size >= 6) {
            return 3;
        } else if (size >= 4) {
            return 2;
        } else if (size >= 2) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 3列的有几行type4
     *
     * @param size
     * @return
     */
    private static int getLinesFor3(int size) {
        if (size >= 9) {
            return 3;
        } else if (size >= 6) {
            return 2;
        } else if (size >= 3) {
            return 1;
        } else {
            return 0;
        }
    }


    /*String HorizontalBigPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/6.png"; //横图1
    String HorizontalBigPic2 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/7.jpg";//横图2
    String smallPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/8.png";//小图标
    String verticalPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/9.jpg";//竖图
    String smallPic2 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/10.png";//1080p小图
    String dongPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/12.gif";//动图gif
    //四个轮播图
    String lunboPic1 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/13.jpg";//轮播图1
    String lunboPic2 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/14.jpg";//轮播图2
    String lunboPic3 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/15.jpg";//轮播图3
    String lunboPic4 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/16.jpg";//轮播图4


    *//**
     * type1+type2+3个type3+type7
     *
     * @return
     *//*
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

    *//**
     * type1+type2+2个type4+type5
     *
     * @return
     *//*
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

    *//**
     * type1+type2+1个type4+type5
     *
     * @return
     *//*
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

    *//**
     * type1+type2+1个type6+1type3
     *
     * @return
     *//*
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

    *//**
     * type1+type2+2个type4+type8
     *
     * @return
     *//*
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
    }*/

    /**
     * 轮播图
     *
     * @return
     *//*
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
            BaseModel middle = new BaseModel(lunboPic2, smallPic2, null, null, "大标题2", "24集全");
            BaseModel right = new BaseModel(lunboPic3, smallPic2, null, null, "大标题3", "36集全");
            BaseModel right1 = new BaseModel(lunboPic4, smallPic2, null, null, "大标题3", "36集全");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            baseModel3461s.add(right);
            baseModel3461s.add(right1);
            ViewModel model346 = new ViewModel(baseModel3461s, 9);
            list.add(model346);
        }
        return list;
    }*/



}
