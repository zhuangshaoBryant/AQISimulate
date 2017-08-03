package com.zhuang.jackyli.aqysimulate.util;

import android.util.Log;

import com.zhuang.jackyli.aqysimulate.bean.Block;
import com.zhuang.jackyli.aqysimulate.bean.BottomBanner;
import com.zhuang.jackyli.aqysimulate.bean.Button;
import com.zhuang.jackyli.aqysimulate.bean.Card;
import com.zhuang.jackyli.aqysimulate.bean.Image;
import com.zhuang.jackyli.aqysimulate.bean.Meta;
import com.zhuang.jackyli.aqysimulate.bean.Page;
import com.zhuang.jackyli.aqysimulate.bean.PageBase;
import com.zhuang.jackyli.aqysimulate.bean.TopBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackyli on 2017/8/2.
 */

public class JsonParseUtil {
    private static final String TAG = "JsonParseUtil";

    public static Page parseJson(String jsonData) throws JSONException {
        //Page对象及成员
        Page page = new Page();
        List<Card> cards = new ArrayList<>();
        PageBase pageBase = new PageBase();
        JSONObject pageObject = new JSONObject(jsonData);
        //获取base
        JSONObject baseObject = pageObject.optJSONObject("base");
        String next_url = baseObject.getString("next_url");
        Log.d(TAG, "base:next_url: " + next_url);
        pageBase.setNext_url(next_url);
        page.setBase(pageBase);
        //获取cards
        JSONArray cardArray = pageObject.optJSONArray("cards");
        for (int i = 0; i < cardArray.length(); i++) {
            JSONObject cardObject = cardArray.getJSONObject(i);
            Card card = new Card();
            //获取card_class
            String card_class = cardObject.getString("card_class");
            Log.d(TAG, "card:card_class: " + card_class);
            card.setCard_class(card_class);
            //获取top_banner
            TopBanner top_banner = getTopBanner(cardObject);
            card.setTop_banner(top_banner);
            //获取bottom_banner
            BottomBanner bottom_banner = getBottomBanner(cardObject);
            card.setBottom_banner(bottom_banner);
            //获取blocks
            List<Block> blocks = getBlocks(cardObject);
            card.setBlocks(blocks);
            cards.add(card);
        }
        page.setCards(cards);
        return page;
    }

    private static List<Block> getBlocks(JSONObject cardObject) throws JSONException {
        JSONArray blockArray = cardObject.optJSONArray("blocks");
        if (blockArray != null) {
            List<Block> blocks = new ArrayList<>();
            for (int i = 0; i < blockArray.length(); i++) {
                Block block = new Block();
                JSONObject blockObject = blockArray.optJSONObject(i);
                //获取images
                JSONArray imageArray = blockObject.optJSONArray("images");
                if (imageArray != null) {
                    List<Image> images = new ArrayList<>();
                    for (int a = 0; a < imageArray.length(); a++) {
                        Image image = new Image();
                        JSONObject imageObject = imageArray.optJSONObject(a);
                        //获取url
                        String url = imageObject.optString("url");
                        image.setUrl(url);
                        Log.d(TAG, "blocks:images:url " + url);
                        //获取marks
                        JSONObject markObject = imageObject.optJSONObject("marks");
                        if (markObject != null) {
                            Image.Mark mark = new Image.Mark();
                            //获取ld_mark
                            JSONObject ld_markObject = markObject.optJSONObject("ld_mark");
                            if (ld_markObject != null) {
                                Image.Mark.LdMark ld_mark = new Image.Mark.LdMark();
                                String t = ld_markObject.optString("t");
                                Log.d(TAG, "blocks:images:marks: ldmark" + t);
                                ld_mark.setT(t);
                                mark.setLd_mark(ld_mark);
                            }
                            //获取rd_mark
                            JSONObject rd_markObject = markObject.optJSONObject("rd_mark");
                            if (rd_markObject != null) {
                                Image.Mark.RdMark rd_mark = new Image.Mark.RdMark();
                                String rt = rd_markObject.optString("t");
                                rd_mark.setT(rt);
                                mark.setRd_mark(rd_mark);
                                Log.d(TAG, "blocks:images:marks: rdmark" + rt);
                            }
                            image.setMarks(mark);
                        }
                        images.add(image);
                    }
                    block.setImages(images);
                }
                //获取metas
                JSONArray metaArray = blockObject.optJSONArray("metas");
                if (metaArray != null) {
                    List<Meta> metas = new ArrayList<>();
                    for (int b = 0; b < metaArray.length(); b++) {
                        JSONObject metaObject = metaArray.getJSONObject(b);
                        Meta meta = new Meta();
                        String text = metaObject.optString("text");
                        meta.setText(text);
                        Log.d(TAG, "blocks:metas:text: " + text);
                        metas.add(meta);
                    }
                    block.setMetas(metas);
                }
                blocks.add(block);
            }
            return blocks;
        }
        return null;
    }

    private static BottomBanner getBottomBanner(JSONObject cardObject) throws JSONException {
        BottomBanner bottom_banner = new BottomBanner();
        JSONObject bottomBannerObject = cardObject.optJSONObject("bottom_banner");
        if (bottomBannerObject != null) {
            JSONArray blockArray = bottomBannerObject.optJSONArray("blocks");
            if (blockArray != null) {
                List<BottomBanner.BottomBlock> blocks = new ArrayList<>();
                for (int j = 0; j < blockArray.length(); j++) {
                    JSONObject blockObject = blockArray.getJSONObject(j);
                    BottomBanner.BottomBlock block = new BottomBanner.BottomBlock();
                    int block_type = blockObject.optInt("block_type");
                    block.setBlock_type(block_type);
                    Log.d(TAG, "bottom_banner:blocks:block_type: " + block_type);
                    //添加buttons
                    JSONArray buttonArray = blockObject.optJSONArray("buttons");
                    if (buttonArray != null) {
                        List<Button> buttons = new ArrayList<>();
                        for (int a = 0; a < buttonArray.length(); a++) {
                            Button button = new Button();
                            JSONObject buttonObject = buttonArray.getJSONObject(a);
                            String text = buttonObject.optString("text");
                            Log.d(TAG, "bottom_banner:blocks:buttons:text: " + text);
                            button.setText(text);
                            buttons.add(button);
                        }
                        block.setButtons(buttons);
                    }

                    blocks.add(block);//List<BottomBanner.BottomBlock>
                }
                bottom_banner.setBlocks(blocks);
            }
            return bottom_banner;
        }
        return null;
    }

    private static TopBanner getTopBanner(JSONObject cardObject) throws JSONException {
        TopBanner top_banner = new TopBanner();
        JSONObject topBannerObject = cardObject.optJSONObject("top_banner");
        if (topBannerObject != null) {
            List<TopBanner.L_Block> l_blocks = new ArrayList<>();
            JSONArray l_blocksArray = topBannerObject.getJSONArray("l_blocks");
            for (int j = 0; j < l_blocksArray.length(); j++) {
                TopBanner.L_Block l_block = new TopBanner.L_Block();
                JSONObject l_blocksObject = l_blocksArray.getJSONObject(j);
                int block_type = l_blocksObject.optInt("block_type");
                l_block.setBlock_type(block_type);
                //添加images
                JSONArray imageArray = l_blocksObject.optJSONArray("images");
                if (imageArray != null) {
                    List<Image> images = new ArrayList<>();
                    for (int a = 0; a < imageArray.length(); a++) {
                        Image image = new Image();
                        JSONObject imageObject = imageArray.getJSONObject(a);
                        String url = imageObject.optString("url");
                        Log.d(TAG, "l_blocks:images:url: " + url);
                        image.setUrl(url);
                        images.add(image);
                    }
                    l_block.setImages(images);
                }
                //添加buttons
                JSONArray buttonArray = l_blocksObject.optJSONArray("buttons");
                if (buttonArray != null) {
                    List<Button> buttons = new ArrayList<>();
                    for (int a = 0; a < buttonArray.length(); a++) {
                        Button button = new Button();
                        JSONObject buttonObject = buttonArray.getJSONObject(a);
                        String text = buttonObject.optString("text");
                        Log.d(TAG, "l_blocks:buttons:text: " + text);
                        button.setText(text);
                        buttons.add(button);
                    }
                    l_block.setButtons(buttons);
                }
                //添加metas
                JSONArray metaArray = l_blocksObject.optJSONArray("metas");
                if (metaArray != null) {
                    List<Meta> metas = new ArrayList<>();  //type2上大标题
                    for (int a = 0; a < metaArray.length(); a++) {
                        Meta meta = new Meta();
                        JSONObject metaObject = metaArray.getJSONObject(a);
                        String text = metaObject.optString("text");
                        Log.d(TAG, "l_blocks:metas:text: " + text);
                        meta.setText(text);
                        metas.add(meta);
                    }
                    l_block.setMetas(metas);
                }
                l_blocks.add(l_block);//List<TopBanner.L_Block>
            }
            top_banner.setL_blocks(l_blocks);
            return top_banner;
        }
        return null;
    }
}
