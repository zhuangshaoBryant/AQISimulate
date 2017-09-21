package com.zhuang.jackyli.aqysimulate.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.util.ToolUtil;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel2 implements AbsModel {

    private ViewModel2Holder mModel2Holder;

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel2Holder = (ViewModel2Holder) holder;
        BaseModel model2 = viewModel.getBaseModels().get(0);
        mModel2Holder.mLeftIco.setImageURI(model2.getFirstPic());
        mModel2Holder.text_textview.setText(model2.getFirstText());
        mModel2Holder.right_textview.setText(model2.getSecondText());
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int modelType) {
        View view = new View(parent.getContext());
        //父布局
        RelativeLayout layout = new RelativeLayout(parent.getContext());
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        relativeLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layout.setLayoutParams(relativeLayoutParams);
        layout.setPadding(ToolUtil.dip2px(parent.getContext(),13),
                ToolUtil.dip2px(parent.getContext(),13),
                ToolUtil.dip2px(parent.getContext(),13),
                ToolUtil.dip2px(parent.getContext(),13));

        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type2_recyclerview_item, parent, false);
        mModel2Holder = new ViewModel2Holder(view);
        return mModel2Holder;
    }

    public static class ViewModel2Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView mLeftIco;
        TextView text_textview, right_textview;

        public ViewModel2Holder(View itemView) {
            super(itemView);
            mLeftIco = (SimpleDraweeView) itemView.findViewById(R.id.left_icon);
            text_textview = (TextView) itemView.findViewById(R.id.text_textview);
            right_textview = (TextView) itemView.findViewById(R.id.right_textview);
        }
    }
}
