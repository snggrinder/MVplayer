package com.itheima.mvplayer.presenter.impl;

import com.itheima.mvplayer.model.YueDanBean;
import com.itheima.mvplayer.network.NetWorkListener;
import com.itheima.mvplayer.network.YueDanRequest;
import com.itheima.mvplayer.presenter.YueDanPresenter;
import com.itheima.mvplayer.view.YueDanView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class YueDanPresenterImp implements YueDanPresenter{

    public  static final String TAG ="YueDanPresenterImp";
    private  YueDanView mYueDanView;

    private List<YueDanBean.PlayListsBean> mList;

    public YueDanPresenterImp(YueDanView view){
        mYueDanView =view;
        mList= new ArrayList<YueDanBean.PlayListsBean>();
    }

    @Override
    public void loadDataList() {

        YueDanRequest.getYueDanRequest(0, new NetWorkListener<YueDanBean>() {
            @Override
            public void onFailed(String s) {

            }

            @Override
            public void onSucess(YueDanBean result) {
                mList.addAll(result.getPlayLists());

                //通知view层更新
                mYueDanView.onDataLoaded();
            }
        }).execute();
    }

    @Override
    public void refresh() {

    }

    @Override
    public void loadMoreData() {

    }

    @Override
    public List<YueDanBean.PlayListsBean> getDataList() {

        return mList;
    }


}
