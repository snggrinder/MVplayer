package com.itheima.mvplayer.presenter.impl;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.itheima.mvplayer.model.HomeListItemBean;
import com.itheima.mvplayer.network.HomeRequest;
import com.itheima.mvplayer.network.NetWorkListener;
import com.itheima.mvplayer.presenter.HomePresenter;
import com.itheima.mvplayer.view.HomeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/11.
 */

public class HomePresenterImpl implements HomePresenter{
    private List<HomeListItemBean> mListData;

    private HomeView mHomeView;


    private Handler mHandler =new Handler(Looper.getMainLooper());

    private Gson mGson;

    public HomePresenterImpl(HomeView view){
        mHomeView=view;
        mGson= new Gson();
        mListData = new ArrayList<HomeListItemBean>();
    }




    @Override
    public void loadDataList() {
        loadHomeData(0);
    }



    @Override
    public void refresh() {
        mListData.clear();
        loadHomeData(0);

    }

    @Override
    public void loadMoreData() {
        loadHomeData(mListData.size());
    }

    @Override
    public List<HomeListItemBean> getDataList() {
        return mListData;
    }

    private void loadHomeData(int offset) {


        HomeRequest.getHomeRequest(0,mListNetWorkListener).execute();

    }

    private NetWorkListener<List<HomeListItemBean>> mListNetWorkListener = new NetWorkListener<List<HomeListItemBean>>() {
        @Override
        public void onFailed(String s) {


        }

        @Override
        public void onSucess(List<HomeListItemBean> result) {
            mListData.addAll(result);
                mHomeView.onDataLoaded();
        }
    };
}
