package com.zhuang.jackyli.aqysimulate.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.R;

import java.util.List;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel1 implements AbsModel {


    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {

    }

    @Override
    public   RecyclerView.ViewHolder getViewHolder(ViewGroup parent,int modelType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type1_divide_recyclerview_item, parent, false);
            ViewModel1Holder model1Holder = new ViewModel1Holder(view);
            return model1Holder;
    }

    public static class ViewModel1Holder extends RecyclerView.ViewHolder {
        public ViewModel1Holder(View itemView) {
            super(itemView);
        }
    }
}
