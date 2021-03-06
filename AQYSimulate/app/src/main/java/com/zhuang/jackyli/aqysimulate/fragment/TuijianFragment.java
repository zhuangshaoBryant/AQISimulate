package com.zhuang.jackyli.aqysimulate.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.MyFragmentAdapter;
import com.zhuang.jackyli.aqysimulate.fragmentpager.ContentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuijianFragment extends Fragment {
    private static String TAG = "TuijianFragment";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentAdapter mFragmentAdapter;
    private List<Fragment> fragments; //fragment集合
    private List<String> titles; //fragment集合

    public TuijianFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tuijian, container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        if(fragments==null){
            init();//初始化Fragment与titles
        }

        Log.d(TAG, "getActivity: "+getActivity());
        mFragmentAdapter = new MyFragmentAdapter(getChildFragmentManager() , fragments, titles);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    private void init() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ContentFragment contentFragment = new ContentFragment();
            fragments.add(contentFragment);
        }
        titles.add("推荐");
        titles.add("新歌声");
        titles.add("热点");
        titles.add("电视剧");
        titles.add("电影");
        titles.add("儿童");
        titles.add("综艺");
        titles.add("动漫");
        titles.add("上海");
        titles.add("订阅");
    }

}
