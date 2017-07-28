package com.zhuang.jackyli.aqysimulate.fragmentpager;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.MyRecyclerViewAdapter;
import com.zhuang.jackyli.aqysimulate.data.ViewModelData;
import com.zhuang.jackyli.aqysimulate.model.ViewModel;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    RecyclerView mCardRecyclerView;
    private List<ViewModel> mDataList;
    private static final String TAG = "ContentFragment";

    public ContentFragment() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //可以在这里保存临时数据
        //saveStateToArguments();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //可以在这里保存临时数据
        //saveStateToArguments();
    }

    private void saveStateToArguments() {
        Bundle b = new Bundle();
        if (mDataList != null) {
            b.putSerializable(TAG, (Serializable) mDataList);
            setArguments(b);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        mCardRecyclerView = (RecyclerView) view.findViewById(R.id.card_recyclerView);


        try {
            if (mDataList == null) {
                mDataList = new ArrayList<>();
                List<ViewModel> list1 = initData();
                mDataList.addAll(list1);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Log.d("hhh", mDataList.size() + "zuizhong ");
        MyRecyclerViewAdapter mRecyclerViewAdapter = new MyRecyclerViewAdapter(mDataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mCardRecyclerView.setLayoutManager(linearLayoutManager);
        mCardRecyclerView.setAdapter(mRecyclerViewAdapter);
        Log.d(TAG, "onCreateView: " + mDataList.size());
        return view;
    }

    @NonNull
    private List<ViewModel> initData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List list = new ArrayList();
        ViewModelData data = new ViewModelData();
        Class clazz = data.getClass();
        Random random = new Random();//默认构造方法
        for (int i = 0; i < 30; i++) {
            int s = random.nextInt(5) + 1;
            String methodName = "addCard" + s;
            Method method = clazz.getMethod(methodName);
            List<ViewModel> list1 = (List<ViewModel>) method.invoke(data);
            list.addAll(list1);
        }
        return list;
    }

}
