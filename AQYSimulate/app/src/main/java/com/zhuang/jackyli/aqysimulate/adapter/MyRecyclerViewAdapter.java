package com.zhuang.jackyli.aqysimulate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.factory.ViewModelFactory;
import com.zhuang.jackyli.aqysimulate.model.ViewModel;

import java.util.List;

/**
 * Created by jackyli on 2017/7/24.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ViewModel> list;

    public MyRecyclerViewAdapter(List<ViewModel> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       return  ViewModelFactory.getViewHolder(parent,viewType);


        /*View view;
        RecyclerView.ViewHolder holder;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type33_recyclerview_item, parent, false);
        holder = new Model346Holder(view, 2, parent);
        return holder;*/
        /*switch (viewType) {
            case TYPE1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type1_divide_recyclerview_item, parent, false);
                holder = new Model1Holder(view);
                return holder;
            case TYPE2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type2_recyclerview_item, parent, false);
                holder = new Model2Holder(view);
                return holder;
        }
        return null;*/
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewModelFactory.onBindData(holder,list.get(position));
        /*Model346 model346 = list.get(position);
        BaseModel left = model346.getBaseModel().get(0);
        BaseModel right = model346.getBaseModel().get(1);
        //左图设置
        ((Model346Holder)holder).mLeftDownTitle.setText(left.getSecondText());
        ((Model346Holder)holder).mLeftUpTitle.setText(left.getFirstText());
        ((Model346Holder)holder).mLeftLeftBottomText.setText(left.getThirdText());
        ((Model346Holder)holder).mLeftRightBottomText.setText(left.getFourText());
        ((Model346Holder)holder).mLeftPicImageview.setAspectRatio(1.5f);
        ((Model346Holder)holder).mLeftRightUpPic.setAspectRatio(1.5f);
        ((Model346Holder)holder).mLeftPicImageview.setImageURI(left.getFirstPic());
        ((Model346Holder)holder).mLeftRightUpPic.setImageURI(left.getSecondPic());
        Log.d(TAG,"测试时间"+SystemClock.currentThreadTimeMillis());
        //右图设置
        ((Model346Holder)holder).mMiddleDownTitle.setText(right.getSecondText());
        ((Model346Holder)holder).mMiddleUpTitle.setText(right.getFirstText());
        ((Model346Holder)holder).mMiddleLeftBottomText.setText(right.getThirdText());
        ((Model346Holder)holder).mMiddleRightBottomText.setText(right.getFourText());
        ((Model346Holder)holder).mMiddlePicImageview.setAspectRatio(1.5f);
        ((Model346Holder)holder).mMiddlePicImageview.setImageURI(right.getFirstPic());
        ((Model346Holder)holder).mMiddleRightUpPic.setAspectRatio(1.5f);
        ((Model346Holder)holder).mMiddleRightUpPic.setImageURI(right.getSecondPic());*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getModelType();
    }
/*

    public static class Model346Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView mLeftPicImageview, mLeftRightUpPic, mMiddlePicImageview, mMiddleRightUpPic, mRightPicImageview, mRightRightUpPic;
        TextView mLeftRightBottomText, mLeftLeftBottomText, mLeftUpTitle, mLeftDownTitle,
                mMiddleRightBottomText, mMiddleLeftBottomText, mMiddleUpTitle, mMiddleDownTitle,
                mRightRightBottomText, mRightLeftBottomText, mRightUpTitle, mRightDownTitle;
        private final LinearLayout mLinearLayout;


        public Model346Holder(View itemView, int countPic, ViewGroup parent) {
            super(itemView);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            switch (countPic) {
                case 1:
                    addLeftView(parent, params);

                    break;
                case 2:
                    addLeftView(parent, params);
                    addMiddleView(parent, params);
                    break;
                case 3:
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
           // Log.d(TAG,"addRightView");
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
            Log.d(TAG,"addMiddleView"+SystemClock.currentThreadTimeMillis());
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
            Log.d(TAG,"addLeftView"+ SystemClock.currentThreadTimeMillis());
        }
    }*/


}
