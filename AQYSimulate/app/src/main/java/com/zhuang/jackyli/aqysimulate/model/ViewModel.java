package com.zhuang.jackyli.aqysimulate.model;

import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel implements Serializable{
    private List<BaseModel> baseModels;
    private int modelType;

    public ViewModel(int modelType) {

        this.modelType = modelType;
    }

    public ViewModel(List<BaseModel> baseModels, int modelType) {

        this.baseModels = baseModels;
        this.modelType = modelType;
    }

    public List<BaseModel> getBaseModels() {
        return baseModels;
    }


    public void setBaseModels(List<BaseModel> baseModels) {
        this.baseModels = baseModels;
    }

    public int getModelType() {
        return modelType;
    }

    public void setModelType(int modelType) {
        this.modelType = modelType;
    }



}
