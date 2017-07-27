package com.zhuang.jackyli.aqysimulate.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;

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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type55_recyclerview_item, parent, false);
        mModel5Holder = new ViewModel5Holder(view, modelType, parent);
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
            rightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type5_layout, mLinearLayout, false);
            rightView.setLayoutParams(params);
            mLinearLayout.addView(rightView);
            mRightGreenSimpleDraweeView = (SimpleDraweeView) rightView.findViewById(R.id.green_imageview);
            mRightGreenText = (TextView) rightView.findViewById(R.id.green_text);
        }

        private void addMiddleView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View middleView;
            middleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type5_layout, mLinearLayout, false);
            middleView.setLayoutParams(params);
            mLinearLayout.addView(middleView);
            mMiddleGreenSimpleDraweeView = (SimpleDraweeView) middleView.findViewById(R.id.green_imageview);
            mMiddleGreenText = (TextView) middleView.findViewById(R.id.green_text);
        }

        private void addLeftView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View leftView;
            leftView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type5_layout, mLinearLayout, false);
            leftView.setLayoutParams(params);
            mLinearLayout.addView(leftView);
            mLeftGreenSimpleDraweeView = (SimpleDraweeView) leftView.findViewById(R.id.green_imageview);
            mLeftGreenText = (TextView) leftView.findViewById(R.id.green_text);
        }
    }
}
