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
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewModelFactory.onBindData(holder,list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getModelType();
    }


}
