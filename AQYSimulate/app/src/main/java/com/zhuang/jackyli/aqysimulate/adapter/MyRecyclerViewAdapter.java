package com.zhuang.jackyli.aqysimulate.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuang.jackyli.aqysimulate.R;

import java.util.List;

/**
 * Created by jackyli on 2017/7/24.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    public static final int TYPE5 = 5;
    public static final int TYPE6 = 6;

    private List<String> list;

    public MyRecyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case TYPE1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type1_divide_recyclerview_item, parent, false);
                holder = new Model1Holder(view);
                return holder;
            case TYPE2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type2_recyclerview_item, parent, false);
                holder = new Model2Holder(view);
                return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class Model1Holder extends RecyclerView.ViewHolder {
        public Model1Holder(View itemView) {
            super(itemView);
        }
    }

    public static class Model2Holder extends RecyclerView.ViewHolder {
        ImageView mLeftIconImageview;
        TextView mTextTextview, mRightTextview;

        public Model2Holder(View itemView) {
            super(itemView);
            mLeftIconImageview = (ImageView) itemView.findViewById(R.id.left_icon_imageview);
            mTextTextview = (TextView) itemView.findViewById(R.id.text_textview);
            mRightTextview = (TextView) itemView.findViewById(R.id.right_textview);
        }
    }

}
