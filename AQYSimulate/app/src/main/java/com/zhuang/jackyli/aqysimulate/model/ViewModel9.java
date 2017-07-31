package com.zhuang.jackyli.aqysimulate.model;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.CyclePagerAdapter;
import com.zhuang.jackyli.aqysimulate.ui.CycleViewPager;
import com.zhuang.jackyli.aqysimulate.ui.ScaleTransformer;

import java.util.List;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel9 implements AbsModel {
    public Context mContext;
    private static ViewModel9Holder mModel9Holder;
    public SimpleDraweeView mLeftPicImageview, mLeftRightUpPic;
    public TextView mLeftRightBottomText, mLeftLeftBottomText, mLeftUpTitle, mLeftDownTitle;

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel9Holder = (ViewModel9Holder) holder;
        mContext = mModel9Holder.myCycleViewPager.parent.getContext();
        List<BaseModel> lists = viewModel.getBaseModels();
        SimpleBannerAdapter pagerAdapter = new SimpleBannerAdapter(lists, mContext);
        mModel9Holder.myCycleViewPager.setPageMargin(5);
        mModel9Holder.myCycleViewPager.setOffscreenPageLimit(3);//显示左右两个viewpager
        mModel9Holder.myCycleViewPager.setPageTransformer(false, new ScaleTransformer());//缩放效果
        mModel9Holder.myCycleViewPager.setAdapter(pagerAdapter);
        mModel9Holder.myCycleViewPager.startAutoScroll();
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int modelType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type9_recyclerview_item, parent, false);
        mModel9Holder = new ViewModel9Holder(view, modelType, parent);
        return mModel9Holder;
    }


    public static class ViewModel9Holder extends RecyclerView.ViewHolder {
        CycleViewPager myCycleViewPager;

        public ViewModel9Holder(View itemView, int modelType, ViewGroup parent) {
            super(itemView);
            myCycleViewPager = (CycleViewPager) itemView.findViewById(R.id.my_lunbo_viewpager);
            myCycleViewPager.setParent(parent);
        }
    }

    class SimpleBannerAdapter extends CyclePagerAdapter {

        private List<BaseModel> lists;
        private Context mContext;

        public SimpleBannerAdapter(List<BaseModel> lists, Context mContext) {
            this.lists = lists;
            this.mContext = mContext;
        }

        @Override
        public int getRealCount() {
            return lists.size();
        }

        @Override
        public View getViewAtRealPosition(final int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.base_type9_layout, container, false);
            }
            BaseModel baseModel = lists.get(position);
            mLeftPicImageview = (SimpleDraweeView) convertView.findViewById(R.id.big_pic);
            mLeftRightUpPic = (SimpleDraweeView) convertView.findViewById(R.id.right_up_pic);
            mLeftRightBottomText = (TextView) convertView.findViewById(R.id.right_bottom_text);
            mLeftLeftBottomText = (TextView) convertView.findViewById(R.id.left_bottom_text);
            mLeftUpTitle = (TextView) convertView.findViewById(R.id.up_title);
            mLeftDownTitle = (TextView) convertView.findViewById(R.id.down_title);

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
            return convertView;
        }
    }
}
