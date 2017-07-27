package com.zhuang.jackyli.aqysimulate.model;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by jackyli on 2017/7/26.
 */

public interface AbsModel {

     void onBindData(RecyclerView.ViewHolder holder,ViewModel viewModel);   // 绑定Holder后的数据操作

    RecyclerView.ViewHolder getViewHolder(ViewGroup parent,int modelType);//获取自身的holder


}
