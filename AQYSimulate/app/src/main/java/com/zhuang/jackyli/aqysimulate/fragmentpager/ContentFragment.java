package com.zhuang.jackyli.aqysimulate.fragmentpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.MyRecyclerViewAdapter;
import com.zhuang.jackyli.aqysimulate.model.BaseModel;
import com.zhuang.jackyli.aqysimulate.model.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    RecyclerView mCardRecyclerView;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        mCardRecyclerView = (RecyclerView) view.findViewById(R.id.card_recyclerView);
        String firstBigPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/6.png";
        String firstBigPic2 = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/7.jpg";
        String secondSmallPic = "https://raw.githubusercontent.com/zhuangshaoBryant/MyAndroidProject/master/Screenshots/8.png";

        List<ViewModel> list = new ArrayList<>();
        list.add(new ViewModel(1));//添加type1

        //添加type2
        List<BaseModel> baseModel2s = new ArrayList<>();
        BaseModel baseModel2 = new BaseModel(secondSmallPic, null, "壮少直播", "快来点击看看吧",null, null);
        baseModel2s.add(baseModel2);
        list.add(new ViewModel(baseModel2s, 2));
        //添加type3
        for (int i = 0; i < 3; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(firstBigPic, secondSmallPic, "大标题", "小标题","14:12", "2017/7/26" );
            BaseModel middle = new BaseModel(firstBigPic2, secondSmallPic, "大标题2", "小标题2","14:13", "2017/7/27");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            ViewModel model346 = new ViewModel(baseModel3461s, 3);
            list.add(model346);
        }
        //添加type7
        List<BaseModel> baseMode7s = new ArrayList<>();
        BaseModel baseMode7 = new BaseModel(secondSmallPic, null, "查看更多内容", null,null, null);
        BaseModel baseMode72 = new BaseModel(secondSmallPic, null, "换一批", null,null, null);
        baseMode7s.add(baseMode7);
        baseMode7s.add(baseMode72);
        list.add(new ViewModel(baseMode7s, 7));

        list.add(new ViewModel(1));//添加type1

        //添加type2
        List<BaseModel> baseModel2ss = new ArrayList<>();
        BaseModel baseModel22 = new BaseModel(secondSmallPic, null, "壮少直播", "快来点击看看吧",null, null);
        baseModel2ss.add(baseModel22);
        list.add(new ViewModel(baseModel2ss, 2));

        for (int i = 0; i < 10; i++) {
            List<BaseModel> baseModel3461s = new ArrayList<>();
            BaseModel left = new BaseModel(firstBigPic, secondSmallPic, "大标题", "小标题","14:12", "2017/7/26");
            BaseModel middle = new BaseModel(firstBigPic2, secondSmallPic, "大标题", "小标题","14:13", "2017/7/27");
            BaseModel right = new BaseModel(firstBigPic2, secondSmallPic, "大标题", "小标题","14:13", "2017/7/27");
            baseModel3461s.add(left);
            baseModel3461s.add(middle);
            baseModel3461s.add(right);
            ViewModel model346 = new ViewModel(baseModel3461s, 4);
            list.add(model346);
        }
        MyRecyclerViewAdapter mRecyclerViewAdapter = new MyRecyclerViewAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mCardRecyclerView.setLayoutManager(linearLayoutManager);
        mCardRecyclerView.setAdapter(mRecyclerViewAdapter);
        return view;
    }

}
