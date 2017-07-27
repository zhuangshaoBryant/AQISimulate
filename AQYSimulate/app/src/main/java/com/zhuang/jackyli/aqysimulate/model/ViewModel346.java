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

public class ViewModel346 implements AbsModel {

    private ViewModel346Holder mModel346Holder;

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel346Holder = (ViewModel346Holder) holder;
        switch (viewModel.getModelType()){
            case 6:
                bindLeftData(viewModel);
                break;
            case 3:
                //左图设置
                bindLeftData(viewModel);
                //中图设置
                bindMiddleData(viewModel);
                break;
            case 4:
                bindLeftData(viewModel);
                bindMiddleData(viewModel);
                bindRightData(viewModel);
                break;
            default:
        }
    }
    /**
     *
     * @param viewModel
     * 绑定右边的数据
     */
    private void bindRightData(ViewModel viewModel) {
        BaseModel middle = viewModel.getBaseModels().get(2);
        mModel346Holder.mRightDownTitle.setText(middle.getSecondText());
        mModel346Holder.mRightUpTitle.setText(middle.getFirstText());
        mModel346Holder.mRightLeftBottomText.setText(middle.getThirdText());
        mModel346Holder.mRightRightBottomText.setText(middle.getFourText());
        mModel346Holder.mRightPicImageview.setAspectRatio(1.5f);
        mModel346Holder.mRightPicImageview.setImageURI(middle.getFirstPic());
        mModel346Holder.mRightRightUpPic.setAspectRatio(1.5f);
        mModel346Holder.mRightRightUpPic.setImageURI(middle.getSecondPic());
    }
    /**
     *
     * @param viewModel
     * 绑定中间的数据
     */
    private void bindMiddleData(ViewModel viewModel) {
        BaseModel middle = viewModel.getBaseModels().get(1);
        mModel346Holder.mMiddleDownTitle.setText(middle.getSecondText());
        mModel346Holder.mMiddleUpTitle.setText(middle.getFirstText());
        mModel346Holder.mMiddleLeftBottomText.setText(middle.getThirdText());
        mModel346Holder.mMiddleRightBottomText.setText(middle.getFourText());
        mModel346Holder.mMiddlePicImageview.setAspectRatio(1.5f);
        mModel346Holder.mMiddlePicImageview.setImageURI(middle.getFirstPic());
        mModel346Holder.mMiddleRightUpPic.setAspectRatio(1.5f);
        mModel346Holder.mMiddleRightUpPic.setImageURI(middle.getSecondPic());
    }
    /**
     *
     * @param viewModel
     * 绑定左边的数据
     */
    private void bindLeftData(ViewModel viewModel) {
        BaseModel left = viewModel.getBaseModels().get(0);
        mModel346Holder.mLeftDownTitle.setText(left.getSecondText());
        mModel346Holder.mLeftUpTitle.setText(left.getFirstText());
        mModel346Holder.mLeftLeftBottomText.setText(left.getThirdText());
        mModel346Holder.mLeftRightBottomText.setText(left.getFourText());
        mModel346Holder.mLeftPicImageview.setAspectRatio(1.5f);
        mModel346Holder.mLeftRightUpPic.setAspectRatio(1.5f);
        mModel346Holder.mLeftPicImageview.setImageURI(left.getFirstPic());
        mModel346Holder.mLeftRightUpPic.setImageURI(left.getSecondPic());
    }

    @Override
    public   RecyclerView.ViewHolder getViewHolder(ViewGroup parent,int modelType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type33_recyclerview_item, parent, false);
        mModel346Holder = new ViewModel346Holder(view, modelType, parent);
        return mModel346Holder;
    }

    public static class ViewModel346Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView mLeftPicImageview, mLeftRightUpPic, mMiddlePicImageview, mMiddleRightUpPic, mRightPicImageview, mRightRightUpPic;
        TextView mLeftRightBottomText, mLeftLeftBottomText, mLeftUpTitle, mLeftDownTitle,
                mMiddleRightBottomText, mMiddleLeftBottomText, mMiddleUpTitle, mMiddleDownTitle,
                mRightRightBottomText, mRightLeftBottomText, mRightUpTitle, mRightDownTitle;
        LinearLayout mLinearLayout;
        public ViewModel346Holder(View itemView,int modelType,ViewGroup parent) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            switch (modelType) {
                case 6:
                    addLeftView(parent, params);

                    break;
                case 3:
                    addLeftView(parent, params);
                    addMiddleView(parent, params);
                    break;
                case 4:
                    addLeftView(parent, params);
                    addMiddleView(parent, params);
                    addRightView(parent, params);
                    break;
                default:
            }
        }

        private void addRightView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View rightView;
            rightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type346_layout, mLinearLayout, false);
            rightView.setLayoutParams(params);
            mLinearLayout.addView(rightView);
            mRightPicImageview = (SimpleDraweeView) rightView.findViewById(R.id.big_pic);
            mRightRightUpPic = (SimpleDraweeView) rightView.findViewById(R.id.right_up_pic);
            mRightRightBottomText = (TextView) rightView.findViewById(R.id.right_bottom_text);
            mRightLeftBottomText = (TextView) rightView.findViewById(R.id.left_bottom_text);
            mRightUpTitle = (TextView) rightView.findViewById(R.id.up_title);
            mRightDownTitle = (TextView) rightView.findViewById(R.id.down_title);
        }

        private void addMiddleView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View middleView;
            middleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type346_layout, mLinearLayout, false);
            middleView.setLayoutParams(params);
            mLinearLayout.addView(middleView);
            mMiddlePicImageview = (SimpleDraweeView) middleView.findViewById(R.id.big_pic);
            mMiddleRightUpPic = (SimpleDraweeView) middleView.findViewById(R.id.right_up_pic);
            mMiddleRightBottomText = (TextView) middleView.findViewById(R.id.right_bottom_text);
            mMiddleLeftBottomText = (TextView) middleView.findViewById(R.id.left_bottom_text);
            mMiddleUpTitle = (TextView) middleView.findViewById(R.id.up_title);
            mMiddleDownTitle = (TextView) middleView.findViewById(R.id.down_title);
        }

        private void addLeftView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View leftView;
            leftView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type346_layout, mLinearLayout, false);
            leftView.setLayoutParams(params);
            mLinearLayout.addView(leftView);
            mLeftPicImageview = (SimpleDraweeView) leftView.findViewById(R.id.big_pic);
            mLeftRightUpPic = (SimpleDraweeView) leftView.findViewById(R.id.right_up_pic);
            mLeftRightBottomText = (TextView) leftView.findViewById(R.id.right_bottom_text);
            mLeftLeftBottomText = (TextView) leftView.findViewById(R.id.left_bottom_text);
            mLeftUpTitle = (TextView) leftView.findViewById(R.id.up_title);
            mLeftDownTitle = (TextView) leftView.findViewById(R.id.down_title);
        }
    }
}
