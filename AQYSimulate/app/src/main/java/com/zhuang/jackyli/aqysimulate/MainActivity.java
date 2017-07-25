package com.zhuang.jackyli.aqysimulate;

import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhuang.jackyli.aqysimulate.fragment.LehuoFragment;
import com.zhuang.jackyli.aqysimulate.fragment.MeFragment;
import com.zhuang.jackyli.aqysimulate.fragment.PaopaoFragment;
import com.zhuang.jackyli.aqysimulate.fragment.TuijianFragment;
import com.zhuang.jackyli.aqysimulate.fragment.VipFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    public static final String TEG="MainActivityTest";
    private RadioButton mTuiJian,mLeHuo,mVip,mMe,mPaoPao;
    private RadioGroup mRadioGroup;
    private TuijianFragment mTuijianFragment;
    private LehuoFragment mLehuoFragment;
    private MeFragment mMeFragment;
    private VipFragment mVipFragment;
    private PaopaoFragment mPaopaoFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFindViewByID();
        changeImageSize();//先改变图标大小
        initView();

    }

    /**
     * 调整图标大小
     */
    private void changeImageSize() {
        changeImageSizeChecked(mTuiJian,true);
        changeImageSizeChecked(mLeHuo,false);
        changeImageSizeChecked(mVip,false);
        changeImageSizeChecked(mMe,false);
        changeImageSizeChecked(mPaoPao,false);
    }

    /**
     * 初始化推荐页面
     */
    private void initView() {
        mTuijianFragment = new TuijianFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_fragment,mTuijianFragment);
        transaction.commit();
        mTuiJian.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }


    private void initFindViewByID() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_group);
        mTuiJian = (RadioButton) findViewById(R.id.tuijian);
        mLeHuo = (RadioButton) findViewById(R.id.lehuo);
        mVip = (RadioButton) findViewById(R.id.vip);
        mMe = (RadioButton) findViewById(R.id.my);
        mPaoPao = (RadioButton) findViewById(R.id.paopao);
        mRadioGroup.setOnCheckedChangeListener(this);

    }

    /**
     * 定义底部标签图片大小:点击了
     */
    private void changeImageSizeChecked(RadioButton radioButton,boolean checked) {
        Drawable drawableChecked = getResources().getDrawable(R.drawable.ico_top_msg_f);
        drawableChecked.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        Drawable drawableNoChecked = getResources().getDrawable(R.drawable.ico_top_msg);
        drawableNoChecked.setBounds(0, 0, 69, 69);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        if(checked){
            radioButton.setCompoundDrawables(null,drawableChecked,null,null);
        }else{
            radioButton.setCompoundDrawables(null,drawableNoChecked,null,null);
        }
    }

    /**
     获取点击事件，初始化那个Fragment布局
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (i){
           case  R.id.tuijian:
                if(mTuijianFragment == null){
                    mTuijianFragment = new TuijianFragment();
                }
                transaction.replace(R.id.content_fragment,mTuijianFragment);
                break;
            case  R.id.lehuo:
                if(mLehuoFragment == null){
                    mLehuoFragment = new LehuoFragment();
                }
                transaction.replace(R.id.content_fragment,mLehuoFragment);
                break;
            case  R.id.vip:
                if(mVipFragment == null){
                    mVipFragment = new VipFragment();
                }
                transaction.replace(R.id.content_fragment,mVipFragment);
                break;
            case  R.id.my:
                if(mMeFragment == null){
                    mMeFragment = new MeFragment();
                }
                transaction.replace(R.id.content_fragment,mMeFragment);
                break;
            case  R.id.paopao:
                if(mPaopaoFragment == null){
                    mPaopaoFragment = new PaopaoFragment();
                }
                transaction.replace(R.id.content_fragment,mPaopaoFragment);
                break;
        }
        transaction.commit();
        setTabState();//每次点击之后设置RadioButton的颜色状态
    }

    /**
     * 设置点击的RadioButton的颜色
     */
    private void setTabState() {
        if (mTuiJian.isChecked()) {
            mTuiJian.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            changeImageSizeChecked(mTuiJian,true);
        } else {
            mTuiJian.setTextColor(ContextCompat.getColor(this, R.color.gray));
            changeImageSizeChecked(mTuiJian,false);
        }

        if (mLeHuo.isChecked()) {
            mLeHuo.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            changeImageSizeChecked(mLeHuo,true);
        } else {
            mLeHuo.setTextColor(ContextCompat.getColor(this, R.color.gray));
            changeImageSizeChecked(mLeHuo,false);
        }
        if (mVip.isChecked()) {
            mVip.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            changeImageSizeChecked(mVip,true);
        } else {
            mVip.setTextColor(ContextCompat.getColor(this, R.color.gray));
            changeImageSizeChecked(mVip,false);
        }
        if (mMe.isChecked()) {
            mMe.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            changeImageSizeChecked(mMe,true);
        } else {
            mMe.setTextColor(ContextCompat.getColor(this, R.color.gray));
            changeImageSizeChecked(mMe,false);
        }
        if (mPaoPao.isChecked()) {
            mPaoPao.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            changeImageSizeChecked(mPaoPao,true);
        } else {
            mPaoPao.setTextColor(ContextCompat.getColor(this, R.color.gray));
            changeImageSizeChecked(mPaoPao,false);
        }

    }
}
