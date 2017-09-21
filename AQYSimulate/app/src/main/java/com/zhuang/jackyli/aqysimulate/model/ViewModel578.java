package com.zhuang.jackyli.aqysimulate.model;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.util.ToolUtil;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel578 implements AbsModel {

    private ViewModel5Holder mModel5Holder;

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel5Holder = (ViewModel5Holder) holder;
        switch (viewModel.getModelType()) {
            case 5:
                bindLeftData(viewModel);
                break;
            case 7:
                //左图设置
                bindLeftData(viewModel);
                //中图设置
                bindMiddleData(viewModel);
                break;
            case 8:
                bindLeftData(viewModel);
                bindMiddleData(viewModel);
                bindRightData(viewModel);
                break;
            default:
        }
    }

    /**
     * @param viewModel 绑定右边的数据
     */
    private void bindRightData(ViewModel viewModel) {
        BaseModel middle = viewModel.getBaseModels().get(2);
        mModel5Holder.mRightGreenText.setText(middle.getFirstText());
        mModel5Holder.mRightGreenSimpleDraweeView.setImageURI(middle.getFirstPic());
    }

    /**
     * @param viewModel 绑定中间的数据
     */
    private void bindMiddleData(ViewModel viewModel) {
        BaseModel middle = viewModel.getBaseModels().get(1);
        mModel5Holder.mMiddleGreenText.setText(middle.getFirstText());
        mModel5Holder.mMiddleGreenSimpleDraweeView.setImageURI(middle.getFirstPic());
    }

    /**
     * @param viewModel 绑定左边的数据
     */
    private void bindLeftData(ViewModel viewModel) {
        BaseModel left = viewModel.getBaseModels().get(0);
        mModel5Holder.mLeftGreenText.setText(left.getFirstText());
        mModel5Holder.mLeftGreenSimpleDraweeView.setImageURI(left.getFirstPic());
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
        layout.setId(R.id.type55_linearlayout);
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type55_recyclerview_item, parent, false);
        mModel5Holder = new ViewModel5Holder(layout, modelType, parent);
        return mModel5Holder;
    }

    public static class ViewModel5Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView mLeftGreenSimpleDraweeView, mMiddleGreenSimpleDraweeView, mRightGreenSimpleDraweeView;
        TextView mLeftGreenText, mMiddleGreenText, mRightGreenText;
        LinearLayout mLinearLayout;

        public ViewModel5Holder(View itemView, int modelType, ViewGroup parent) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.type55_linearlayout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            switch (modelType) {
                case 5:
                    addLeftView(parent, params);

                    break;
                case 7:
                    addLeftView(parent, params);
                    addMiddleView(parent, params);
                    break;
                case 8:
                    addLeftView(parent, params);
                    addMiddleView(parent, params);
                    addRightView(parent, params);
                    break;
                default:
            }
        }

        private void addRightView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View rightView;
            rightView = getType578View(parent);
            //rightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type578_layout, mLinearLayout, false);
            rightView.setLayoutParams(params);
            mLinearLayout.addView(rightView);
            mRightGreenSimpleDraweeView = (SimpleDraweeView) rightView.findViewById(R.id.green_imageview);
            mRightGreenText = (TextView) rightView.findViewById(R.id.green_text);
        }

        private void addMiddleView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View middleView;
            middleView = getType578View(parent);
            //middleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type578_layout, mLinearLayout, false);
            middleView.setLayoutParams(params);
            mLinearLayout.addView(middleView);
            mMiddleGreenSimpleDraweeView = (SimpleDraweeView) middleView.findViewById(R.id.green_imageview);
            mMiddleGreenText = (TextView) middleView.findViewById(R.id.green_text);
        }

        private void addLeftView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View leftView;
            leftView = getType578View(parent);
            //leftView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type578_layout, mLinearLayout, false);
            leftView.setLayoutParams(params);
            mLinearLayout.addView(leftView);
            mLeftGreenSimpleDraweeView = (SimpleDraweeView) leftView.findViewById(R.id.green_imageview);
            mLeftGreenText = (TextView) leftView.findViewById(R.id.green_text);
        }
    }

    private static View getType578View(ViewGroup parent){
        //根布局
        LinearLayout layout = new LinearLayout(parent.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(layoutParams);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(ToolUtil.dip2px(parent.getContext(),20),
                ToolUtil.dip2px(parent.getContext(),20),
                ToolUtil.dip2px(parent.getContext(),20),
                ToolUtil.dip2px(parent.getContext(),20));

        //TextView
        TextView green_text = new TextView(parent.getContext());
        LinearLayout.LayoutParams up_title_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        green_text.setLayoutParams(up_title_layoutParams);
        green_text.setId(R.id.green_text);
        green_text.setTextColor(Color.parseColor("#49b53f"));
        green_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        green_text.setPadding(0, 0,
                ToolUtil.dip2px(parent.getContext(),10), 0);
        layout.addView(green_text);

        //SimpleDraweeView控件
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(parent.getContext());
        LinearLayout.LayoutParams simpleDraweeViewLayoutParams = new LinearLayout.LayoutParams(
                ToolUtil.dip2px(parent.getContext(),12),
                ToolUtil.dip2px(parent.getContext(),12));
        simpleDraweeView.setLayoutParams(simpleDraweeViewLayoutParams);
        simpleDraweeView.setId(R.id.green_imageview);
        layout.addView(simpleDraweeView);
        return layout;
    }

}
