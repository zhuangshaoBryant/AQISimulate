package com.zhuang.jackyli.aqysimulate.model;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.CyclePagerAdapter;
import com.zhuang.jackyli.aqysimulate.ui.CycleViewPager;
import com.zhuang.jackyli.aqysimulate.ui.ScaleTransformer;
import com.zhuang.jackyli.aqysimulate.util.ToolUtil;

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
        LinearLayout layout = new LinearLayout(parent.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(layoutParams);
        layout.setClipChildren(false);

        //CycleViewPager
        CycleViewPager cycleViewPager = new CycleViewPager(parent.getContext());
        LinearLayout.LayoutParams cycleViewPager_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ToolUtil.dip2px(parent.getContext(),200)
        );
        cycleViewPager_layoutParams.setMargins(ToolUtil.dip2px(parent.getContext(),20),0,
                ToolUtil.dip2px(parent.getContext(),20),ToolUtil.dip2px(parent.getContext(),10));
        cycleViewPager.setLayoutParams(cycleViewPager_layoutParams);
        cycleViewPager.setId(R.id.my_lunbo_viewpager);
        cycleViewPager.setClipChildren(false);
        cycleViewPager.setAutoScrollInterval(5000);
        cycleViewPager.setPageSwitchDuration(800);
        layout.addView(cycleViewPager);
        // /View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type9_recyclerview_item, parent, false);
        mModel9Holder = new ViewModel9Holder(layout, modelType, parent);
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
                convertView = getType9View(container);
                //convertView = LayoutInflater.from(mContext).inflate(R.layout.base_type9_layout, container, false);
            }
            BaseModel baseModel = lists.get(position);
            mLeftPicImageview = (SimpleDraweeView) convertView.findViewById(R.id.big_pic9);
            mLeftRightUpPic = (SimpleDraweeView) convertView.findViewById(R.id.right_up_pic9);
            mLeftRightBottomText = (TextView) convertView.findViewById(R.id.right_bottom_text9);
            mLeftLeftBottomText = (TextView) convertView.findViewById(R.id.left_bottom_text9);
            mLeftUpTitle = (TextView) convertView.findViewById(R.id.up_title9);
            mLeftDownTitle = (TextView) convertView.findViewById(R.id.down_title9);

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

    private static View getType9View(ViewGroup parent){
        //根布局
        LinearLayout layout = new LinearLayout(parent.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(layoutParams);
        layout.setPadding(0,0, ToolUtil.dip2px(parent.getContext(),1),0);

        //FrameLayout布局
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        LinearLayout.LayoutParams frameLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        frameLayout.setLayoutParams(frameLayoutParams);

        ////////////frameLayout里的子布局///////////////
        //SimpleDraweeView控件
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(parent.getContext());
        FrameLayout.LayoutParams simpleDraweeViewLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        simpleDraweeView.setLayoutParams(simpleDraweeViewLayoutParams);
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        simpleDraweeView.setId(R.id.big_pic9);
        simpleDraweeView.getHierarchy().setPlaceholderImage(R.drawable.defalt_pic);
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadius(ToolUtil.dip2px(parent.getContext(),5));
       // roundingParams.setRoundAsCircle(true);
        simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
        frameLayout.addView(simpleDraweeView);

        //SimpleDraweeView控件
        SimpleDraweeView right_up_pic = new SimpleDraweeView(parent.getContext());
        FrameLayout.LayoutParams right_up_picLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                ToolUtil.dip2px(parent.getContext(),15));
        right_up_picLayoutParams.gravity = Gravity.RIGHT;
        right_up_pic.setLayoutParams(right_up_picLayoutParams);
        right_up_pic.setId(R.id.right_up_pic9);
        frameLayout.addView(right_up_pic);

        //TextView控件
        TextView right_bottom_text = new TextView(parent.getContext());
        FrameLayout.LayoutParams right_textviewLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        right_textviewLayoutParams.gravity = Gravity.RIGHT|Gravity.BOTTOM;
        right_textviewLayoutParams.setMargins(0,0,ToolUtil.dip2px(parent.getContext(),7),
                ToolUtil.dip2px(parent.getContext(),5));
        right_bottom_text.setLayoutParams(right_textviewLayoutParams);
        right_bottom_text.setGravity(Gravity.CENTER);
        right_bottom_text.setId(R.id.right_bottom_text9);
        right_bottom_text.setTextColor(Color.parseColor("#ffffff"));
        right_bottom_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
        right_bottom_text.setPadding(ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2));
        frameLayout.addView(right_bottom_text);

        //TextView控件
        TextView left_bottom_text = new TextView(parent.getContext());
        FrameLayout.LayoutParams left_textviewLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        left_textviewLayoutParams.gravity = Gravity.LEFT|Gravity.BOTTOM;
        left_textviewLayoutParams.setMargins(0,0,ToolUtil.dip2px(parent.getContext(),7),
                ToolUtil.dip2px(parent.getContext(),5));
        left_bottom_text.setLayoutParams(left_textviewLayoutParams);
        left_bottom_text.setGravity(Gravity.CENTER);
        left_bottom_text.setId(R.id.left_bottom_text9);
        left_bottom_text.setTextColor(Color.parseColor("#ffffff"));
        left_bottom_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        left_bottom_text.setPadding(ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2));
        left_bottom_text.getPaint().setFakeBoldText(true);
        frameLayout.addView(left_bottom_text);
        //////////////framelayout结束/////////////

        layout.addView(frameLayout);

        //TextView
        TextView up_title = new TextView(parent.getContext());
        LinearLayout.LayoutParams up_title_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        up_title.setLayoutParams(up_title_layoutParams);
        up_title.setId(R.id.up_title9);
        up_title.setTextColor(Color.parseColor("#ff000000"));
        up_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
        up_title.setPadding(ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5));
        up_title.setMaxLines(1);
        up_title.setEllipsize(TextUtils.TruncateAt.END);
        layout.addView(up_title);

        //TextView
        TextView down_title = new TextView(parent.getContext());
        LinearLayout.LayoutParams down_title_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        down_title.setLayoutParams(down_title_layoutParams);
        down_title.setId(R.id.down_title9);
        down_title.setTextColor(Color.parseColor("#5c5a5a"));
        down_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,11);
        down_title.setPadding(ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5));
        down_title.setMaxLines(1);
        down_title.setEllipsize(TextUtils.TruncateAt.END);
        layout.addView(down_title);

        return layout;
    }
}
