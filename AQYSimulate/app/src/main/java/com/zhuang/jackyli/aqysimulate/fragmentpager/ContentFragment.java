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
        View view =  inflater.inflate(R.layout.fragment_content, container, false);
        mCardRecyclerView = (RecyclerView)view.findViewById(R.id.card_recyclerView);
        List<String> list = new ArrayList<>();
        for (int i=0;i<100;i++){
            list.add("这是Item"+i+1);
        }
        MyRecyclerViewAdapter mRecyclerViewAdapter = new MyRecyclerViewAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mCardRecyclerView.setLayoutManager(linearLayoutManager);
        mCardRecyclerView.setAdapter(mRecyclerViewAdapter);
        return view;
    }

}
