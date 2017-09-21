package com.zhuang.jackyli.aqysimulate.model;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.util.ToolUtil;

/**
 * Created by jackyli on 2017/7/26.
 */

public class ViewModel346 implements AbsModel {

    private ViewModel346Holder mModel346Holder;

    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ViewModel viewModel) {
        mModel346Holder = (ViewModel346Holder) holder;
        switch (viewModel.getModelType()) {
            case 6:
                bindLeftData(viewModel, 1.8f);
                break;
            case 3:
                //左图设置
                bindLeftData(viewModel, 1.8f);
                //中图设置
                bindMiddleData(viewModel, 1.8f);
                break;
            case 4:
                bindLeftData(viewModel, 0.76f);
                bindMiddleData(viewModel, 0.76f);
                bindRightData(viewModel, 0.76f);
                break;
            default:
        }
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int modelType) {
        LinearLayout layout = new LinearLayout(parent.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(layoutParams);
        layout.setId(R.id.linear_layout);

        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type33_recyclerview_item, parent, false);
        mModel346Holder = new ViewModel346Holder(layout, modelType, parent);
        return mModel346Holder;
    }

    public static class ViewModel346Holder extends RecyclerView.ViewHolder {
        SimpleDraweeView mLeftPicImageview, mLeftRightUpPic, mMiddlePicImageview, mMiddleRightUpPic, mRightPicImageview, mRightRightUpPic;
        TextView mLeftRightBottomText, mLeftLeftBottomText, mLeftUpTitle, mLeftDownTitle,
                mMiddleRightBottomText, mMiddleLeftBottomText, mMiddleUpTitle, mMiddleDownTitle,
                mRightRightBottomText, mRightLeftBottomText, mRightUpTitle, mRightDownTitle;
        LinearLayout mLinearLayout;

        public ViewModel346Holder(View itemView, int modelType, ViewGroup parent) {
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
                    break;
            }
        }

        private void addRightView(ViewGroup parent, LinearLayout.LayoutParams params) {
            View rightView;
            rightView = getType346View(parent);
            //rightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type346_layout, mLinearLayout, false);
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
            middleView = getType346View(parent);
            //middleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type346_layout, mLinearLayout, false);
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
            leftView = getType346View(parent);
           // leftView = LayoutInflater.from(parent.getContext()).inflate(R.layout.base_type346_layout, mLinearLayout, false);
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

    private static View getType346View(ViewGroup parent){
        //根布局
        LinearLayout layout = new LinearLayout(parent.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(layoutParams);
        layout.setPadding(0,0, ToolUtil.dip2px(parent.getContext(),1),0);

        //FrameLayout布局
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        LinearLayout.LayoutParams frameLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        frameLayout.setLayoutParams(frameLayoutParams);

        ////////////frameLayout里的子布局///////////////
        //SimpleDraweeView控件
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(parent.getContext());
        FrameLayout.LayoutParams simpleDraweeViewLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        simpleDraweeView.setLayoutParams(simpleDraweeViewLayoutParams);
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        simpleDraweeView.setId(R.id.big_pic);
        simpleDraweeView.getHierarchy().setPlaceholderImage(R.drawable.defalt_pic);
        frameLayout.addView(simpleDraweeView);

        //SimpleDraweeView控件
        SimpleDraweeView right_up_pic = new SimpleDraweeView(parent.getContext());
        FrameLayout.LayoutParams right_up_picLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                ToolUtil.dip2px(parent.getContext(),15));
        right_up_picLayoutParams.gravity = Gravity.RIGHT;
        right_up_pic.setLayoutParams(right_up_picLayoutParams);
        right_up_pic.setId(R.id.right_up_pic);
        frameLayout.addView(right_up_pic);

        //TextView控件
        TextView right_bottom_text = new TextView(parent.getContext());
        FrameLayout.LayoutParams right_textviewLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        right_textviewLayoutParams.gravity = Gravity.RIGHT|Gravity.BOTTOM;
        right_bottom_text.setLayoutParams(right_textviewLayoutParams);
        right_bottom_text.setGravity(Gravity.CENTER);
        right_bottom_text.setId(R.id.right_bottom_text);
        right_bottom_text.setTextColor(Color.parseColor("#ffffff"));
        right_bottom_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        right_bottom_text.setPadding(ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2));
        frameLayout.addView(right_bottom_text);

        //TextView控件
        TextView left_bottom_text = new TextView(parent.getContext());
        FrameLayout.LayoutParams left_textviewLayoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);
        left_textviewLayoutParams.gravity = Gravity.LEFT|Gravity.BOTTOM;
        left_bottom_text.setLayoutParams(left_textviewLayoutParams);
        left_bottom_text.setGravity(Gravity.CENTER);
        left_bottom_text.setId(R.id.left_bottom_text);
        left_bottom_text.setTextColor(Color.parseColor("#ffffff"));
        left_bottom_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
        left_bottom_text.setPadding(ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2),
                ToolUtil.dip2px(parent.getContext(),2));
        frameLayout.addView(left_bottom_text);
        //////////////framelayout结束/////////////

        layout.addView(frameLayout);

        //TextView
        TextView up_title = new TextView(parent.getContext());
        LinearLayout.LayoutParams up_title_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        up_title.setLayoutParams(up_title_layoutParams);
        up_title.setId(R.id.up_title);
        up_title.setTextColor(Color.parseColor("#ff000000"));
        up_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
        up_title.setPadding(ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5));
        up_title.setMaxLines(1);
        up_title.setEllipsize(TextUtils.TruncateAt.END);
        layout.addView(up_title);

        //TextView
        TextView down_title = new TextView(parent.getContext());
        LinearLayout.LayoutParams down_title_layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        down_title.setLayoutParams(down_title_layoutParams);
        down_title.setId(R.id.down_title);
        down_title.setTextColor(Color.parseColor("#5c5a5a"));
        down_title.setTextSize(TypedValue.COMPLEX_UNIT_SP,11);
        down_title.setPadding(ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5),
                ToolUtil.dip2px(parent.getContext(),5));
        down_title.setMaxLines(1);
        down_title.setEllipsize(TextUtils.TruncateAt.END);
        layout.addView(down_title);

        return layout;
    }

    /**
     *
     * @param viewModel
     * 绑定右边的数据
     */
    private void bindRightData(ViewModel viewModel, float radio) {
        BaseModel right = viewModel.getBaseModels().get(2);
        mModel346Holder.mRightDownTitle.setText(right.getSecondText());
        mModel346Holder.mRightUpTitle.setText(right.getFirstText());
        mModel346Holder.mRightLeftBottomText.setText(right.getThirdText());
        mModel346Holder.mRightRightBottomText.setText(right.getFourText());
        mModel346Holder.mRightRightUpPic.setAspectRatio(1.5f);
        mModel346Holder.mRightRightUpPic.setImageURI(right.getSecondPic());
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(right.getFirstPic()))
                .setAutoPlayAnimations(true)
                .build();
        mModel346Holder.mRightPicImageview.setAspectRatio(radio);
        mModel346Holder.mRightPicImageview.setController(draweeController);
    }

    /**
     * @param viewModel 绑定中间的数据
     */
    private void bindMiddleData(ViewModel viewModel, float radio) {
        BaseModel middle = viewModel.getBaseModels().get(1);
        mModel346Holder.mMiddleDownTitle.setText(middle.getSecondText());
        mModel346Holder.mMiddleUpTitle.setText(middle.getFirstText());
        mModel346Holder.mMiddleLeftBottomText.setText(middle.getThirdText());
        mModel346Holder.mMiddleRightBottomText.setText(middle.getFourText());
        mModel346Holder.mMiddleRightUpPic.setAspectRatio(1.5f);
        mModel346Holder.mMiddleRightUpPic.setImageURI(middle.getSecondPic());
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(middle.getFirstPic()))
                .setAutoPlayAnimations(true)
                .build();
        mModel346Holder.mMiddlePicImageview.setAspectRatio(radio);
        mModel346Holder.mMiddlePicImageview.setController(draweeController);
    }

    /**
     * @param viewModel 绑定左边的数据
     */
    private void bindLeftData(ViewModel viewModel, float radio) {
        BaseModel left = viewModel.getBaseModels().get(0);
        mModel346Holder.mLeftDownTitle.setText(left.getSecondText());
        mModel346Holder.mLeftUpTitle.setText(left.getFirstText());
        mModel346Holder.mLeftLeftBottomText.setText(left.getThirdText());
        mModel346Holder.mLeftRightBottomText.setText(left.getFourText());
        mModel346Holder.mLeftRightUpPic.setAspectRatio(1.5f);
        mModel346Holder.mLeftRightUpPic.setImageURI(left.getSecondPic());
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(left.getFirstPic()))
                .setAutoPlayAnimations(true)
                .build();
        mModel346Holder.mLeftPicImageview.setAspectRatio(radio);
        mModel346Holder.mLeftPicImageview.setController(draweeController);
    }
}
