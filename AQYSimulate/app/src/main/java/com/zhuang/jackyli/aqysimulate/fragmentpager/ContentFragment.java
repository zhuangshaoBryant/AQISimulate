package com.zhuang.jackyli.aqysimulate.fragmentpager;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhuang.jackyli.aqysimulate.R;
import com.zhuang.jackyli.aqysimulate.adapter.MyRecyclerViewAdapter;
import com.zhuang.jackyli.aqysimulate.bean.Page;
import com.zhuang.jackyli.aqysimulate.constant.Constant;
import com.zhuang.jackyli.aqysimulate.data.ViewModelData;
import com.zhuang.jackyli.aqysimulate.model.ViewModel;
import com.zhuang.jackyli.aqysimulate.util.HttpCallbackStringListener;
import com.zhuang.jackyli.aqysimulate.util.HttpUtil;
import com.zhuang.jackyli.aqysimulate.util.JsonParseUtil;

import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    RecyclerView mCardRecyclerView;
    private List<ViewModel> mDataList;
    private static final String TAG = "ContentFragment";
    private MyRecyclerViewAdapter mRecyclerViewAdapter;
    String mNextUrl;
    private LinearLayoutManager mLinearLayoutManager;
    private boolean isLoading = false;

    public ContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        mCardRecyclerView = (RecyclerView) view.findViewById(R.id.card_recyclerView);

        mDataList = new ArrayList<>();
        //第一次请求url
        getPageFromNet(getActivity(), Constant.URL, new DataCallback() {
            @Override
            public void onResult(Page page) {
                List<ViewModel> list1 = ViewModelData.getData(page);
                mDataList.addAll(list1);
                mRecyclerViewAdapter.notifyDataSetChanged();
                mNextUrl = ViewModelData.getNextUrl(page);
            }
        });
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(mDataList);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mCardRecyclerView.setLayoutManager(mLinearLayoutManager);
        mCardRecyclerView.setAdapter(mRecyclerViewAdapter);

        mCardRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0){ //向下滑动
                    int visibleItemCount = mLinearLayoutManager.getChildCount();//可见项的个数
                    int totalItemCount = mLinearLayoutManager.getItemCount();//全部的个数
                    int pastVisibleItems = mLinearLayoutManager.findFirstVisibleItemPosition();//找到第一个可见的项目

                    if (visibleItemCount+pastVisibleItems>=(totalItemCount-10)){
                        isLoading = true;
                        if(mNextUrl!=null){
                            mNextUrl = mNextUrl+Constant.HOU_ZHUI;
                            getPageFromNet(getActivity(), mNextUrl, new DataCallback() {
                                @Override
                                public void onResult(Page page) {
                                    List<ViewModel> list1 = ViewModelData.getData(page);
                                    mDataList.addAll(list1);
                                    mRecyclerViewAdapter.notifyDataSetChanged();
                                    mNextUrl = ViewModelData.getNextUrl(page);
                                    isLoading = false;
                                }
                            });
                        }else {
                            Toast.makeText(getActivity(),"已经到底了",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        ////////////////
        /*mCardRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/

        return view;
    }


    public void getPageFromNet(Context context, String url, final DataCallback cb) {
        HttpUtil.doGet(context, url, new HttpCallbackStringListener() {
            @Override
            public void onFinish(String response) {
                try {
                    Page page = JsonParseUtil.parseJson(response);
                    cb.onResult(page);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    public static interface DataCallback {
        void onResult(Page page);
    }

   /* @NonNull
    private List<ViewModel> initData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List list = new ArrayList();
        ViewModelData data = new ViewModelData();
        Class clazz = data.getClass();
        Random random = new Random();//默认构造方法
        for (int i = 0; i < 30; i++) {
            int s = random.nextInt(6) + 1;
            String methodName = "addCard" + s;
            Method method = clazz.getMethod(methodName);
            List<ViewModel> list1 = (List<ViewModel>) method.invoke(data);
            list.addAll(list1);
        }
        return list;
    }*/

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
}
