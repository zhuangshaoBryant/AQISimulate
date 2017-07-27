package com.zhuang.jackyli.aqysimulate.factory;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.model.ViewModel;
import com.zhuang.jackyli.aqysimulate.model.ViewModel1;
import com.zhuang.jackyli.aqysimulate.model.ViewModel2;
import com.zhuang.jackyli.aqysimulate.model.ViewModel346;
import com.zhuang.jackyli.aqysimulate.model.ViewModel578;

/**
 * Created by jackyli on 2017/7/27.
 */

public class ViewModelFactory {

    public static void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        switch (viewModel.getModelType()) {
            case 1:
                new ViewModel1().onBindData(holder, viewModel);
                break;
            case 2:
                new ViewModel2().onBindData(holder, viewModel);
                break;
            case 3:
            case 4:
            case 6:
                new ViewModel346().onBindData(holder, viewModel);
                break;
            case 5:
            case 7:
            case 8:
                new ViewModel578().onBindData(holder, viewModel);
                break;
            default:
        }
    }


    public static RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int modelType) {
        switch (modelType) {
            case 1:
                return new ViewModel1().getViewHolder(parent, modelType);
            case 2:
                return new ViewModel2().getViewHolder(parent, modelType);
            case 3:
            case 4:
            case 6:
                return new ViewModel346().getViewHolder(parent, modelType);
            case 5:
            case 7:
            case 8:
                return new ViewModel578().getViewHolder(parent, modelType);
            default:

        }
        return null;
    }
}
