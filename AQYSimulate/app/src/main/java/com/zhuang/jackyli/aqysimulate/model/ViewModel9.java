package com.zhuang.jackyli.aqysimulate.model;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.MyPagerAdapter;
import com.zhuang.jackyli.aqysimulate.ui.MyCycleViewPager;
import com.zhuang.jackyli.aqysimulate.ui.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel9 implements AbsModel {
    public final static String TAG = "ViewModel999999999";

    private ViewModel9Holder mModel9Holder;
    SimpleDraweeView mLeftPicImageview, mLeftRightUpPic;
    TextView mLeftRightBottomText, mLeftLeftBottomText, mLeftUpTitle, mLeftDownTitle;
    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel9Holder = (ViewModel9Holder) holder;
        View view;
        List<BaseModel> lists = viewModel.getBaseModels();
        final List<View> views = new ArrayList<>();
        
        for (BaseModel baseModel : lists) {
            view = LayoutInflater.from(mModel9Holder.myCycleViewPager.parent.getContext()).inflate(R.layout.base_type9_layout, mModel9Holder.myCycleViewPager, false);
            mLeftPicImageview = (SimpleDraweeView) view.findViewById(R.id.big_pic);
            mLeftRightUpPic = (SimpleDraweeView) view.findViewById(R.id.right_up_pic);
            mLeftRightBottomText = (TextView) view.findViewById(R.id.right_bottom_text);
            mLeftLeftBottomText = (TextView) view.findViewById(R.id.left_bottom_text);
            mLeftUpTitle = (TextView) view.findViewById(R.id.up_title);
            mLeftDownTitle = (TextView) view.findViewById(R.id.down_title);
            
            mLeftDownTitle.setText(baseModel.getSecondText());
            mLeftUpTitle.setText(baseModel.getFirstText());
            mLeftLeftBottomText.setText(baseModel.getThirdText());
            mLeftRightBottomText.setText(baseModel.getFourText());
            mLeftRightUpPic.setAspectRatio(1.5f);
            mLeftRightUpPic.setImageURI(baseModel.getSecondPic());
            DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(baseModel.getFirstPic()))
                    .setAutoPlayAnimations(true)
                    .build();
            mLeftPicImageview.setAspectRatio(1.8f);
            mLeftPicImageview.setController(draweeController);
            views.add(view);

        }
        Log.d(TAG, "onBindData: views.size"+views.size());

        PagerAdapter pagerAdapter = new MyPagerAdapter(views);
        mModel9Holder.myCycleViewPager.setPageMargin(5);
        mModel9Holder.myCycleViewPager.setOffscreenPageLimit(3);//显示左右两个viewpager
        mModel9Holder.myCycleViewPager.setPageTransformer(false,new ScaleTransformer());//缩放效果
        mModel9Holder.myCycleViewPager.setAdapter(pagerAdapter);
        //int firstPage = Integer.MAX_VALUE / 2 / views.size() * views.size();
        mModel9Holder.myCycleViewPager.setCurrentItem(399, false);
    }

    @Override
    public   RecyclerView.ViewHolder getViewHolder(ViewGroup parent,int modelType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type9_recyclerview_item, parent, false);
        mModel9Holder = new ViewModel9Holder(view, modelType, parent);
        return mModel9Holder;
    }





    public static class ViewModel9Holder extends RecyclerView.ViewHolder {
        MyCycleViewPager myCycleViewPager;
        public ViewModel9Holder(View itemView,int modelType,ViewGroup parent) {
            super(itemView);
            myCycleViewPager = (MyCycleViewPager) itemView.findViewById(R.id.my_lunbo_viewpager);
            myCycleViewPager.setParent(parent);
        }
    }
}
