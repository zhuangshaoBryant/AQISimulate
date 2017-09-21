package com.zhuang.jackyli.aqysimulate.model;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.util.ToolUtil;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel2 implements AbsModel {

    private ViewModel2Holder mModel2Holder;

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel2Holder = (ViewModel2Holder) holder;
        BaseModel model2 = viewModel.getBaseModels().get(0);
        mModel2Holder.mLeftIco.setImageURI(model2.getFirstPic());
        mModel2Holder.text_textview.setText(model2.getFirstText());
        mModel2Holder.right_textview.setText(model2.getSecondText());
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int modelType) {
        //父布局
        RelativeLayout layout = new RelativeLayout(parent.getContext());
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        relativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layout.setLayoutParams(relativeLayoutParams);
        layout.setPadding(ToolUtil.dip2px(parent.getContext(),13),
                ToolUtil.dip2px(parent.getContext(),13),
                ToolUtil.dip2px(parent.getContext(),13),
                ToolUtil.dip2px(parent.getContext(),13));

        //SimpleDraweeView控件
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(parent.getContext());
        RelativeLayout.LayoutParams simpleDraweeViewLayoutParams = new RelativeLayout.LayoutParams(
                ToolUtil.dip2px(parent.getContext(),24),
                ToolUtil.dip2px(parent.getContext(),24));
        simpleDraweeViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_START);
        simpleDraweeView.setLayoutParams(simpleDraweeViewLayoutParams);
        simpleDraweeView.setId(R.id.left_icon);
        layout.addView(simpleDraweeView);

        //TextView控件
        TextView text_textview = new TextView(parent.getContext());
        RelativeLayout.LayoutParams text_textviewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        text_textviewLayoutParams.addRule(RelativeLayout.RIGHT_OF,simpleDraweeView.getId());
        text_textviewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        text_textview.setLayoutParams(text_textviewLayoutParams);
        text_textview.setId(R.id.text_textview);
        text_textview.setPadding(ToolUtil.dip2px(parent.getContext(),5),0,0,0);
        text_textview.setTextColor(Color.parseColor("#ff000000"));
        text_textview.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        TextPaint textPaint = text_textview.getPaint();
        textPaint.setFakeBoldText(true);
        layout.addView(text_textview);

        //ImageView
        ImageView right_arrowImageView = new ImageView(parent.getContext());
        RelativeLayout.LayoutParams right_arrowImageViewLayoutParams = new RelativeLayout.LayoutParams(
                ToolUtil.dip2px(parent.getContext(),18),
                ToolUtil.dip2px(parent.getContext(),18));
        right_arrowImageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        right_arrowImageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        right_arrowImageView.setLayoutParams(right_arrowImageViewLayoutParams);
        right_arrowImageView.setBackgroundResource(R.drawable.search_arrow_right);
        right_arrowImageView.setId(R.id.right_arrow);
        layout.addView(right_arrowImageView);

        //TextView控件
        TextView right_textview = new TextView(parent.getContext());
        RelativeLayout.LayoutParams right_textviewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        right_textviewLayoutParams.addRule(RelativeLayout.LEFT_OF,right_arrowImageView.getId());
        right_textviewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        right_textview.setLayoutParams(right_textviewLayoutParams);
        right_textview.setId(R.id.right_textview);
        right_textview.setTextColor(Color.parseColor("#5c5a5a"));
        right_textview.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
        layout.addView(right_textview);

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type2_recyclerview_item, parent, false);
        mModel2Holder = new ViewModel2Holder(layout);
        return mModel2Holder;
    }

    public static class ViewModel2Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView mLeftIco;
        TextView text_textview, right_textview;

        public ViewModel2Holder(View itemView) {
            super(itemView);
            mLeftIco = (SimpleDraweeView) itemView.findViewById(R.id.left_icon);
            text_textview = (TextView) itemView.findViewById(R.id.text_textview);
            right_textview = (TextView) itemView.findViewById(R.id.right_textview);
        }
    }
}
