package com.itheima.mvplayer.presenter.impl;

import com.itheima.mvplayer.model.YueDanBean;
import com.itheima.mvplayer.network.NetworkListener;
import com.itheima.mvplayer.network.YueDanRequest;
import com.itheima.mvplayer.presenter.BaseListPresenter;
import com.itheima.mvplayer.view.BaseListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class YueDanPresenterImpl implements BaseListPresenter<YueDanBean.PlayListsBean>{

    public  static final String TAG ="YueDanPresenterImpl";
    public BaseListView mYueDanView;

    private List<YueDanBean.PlayListsBean> mDataList;

    public YueDanPresenterImpl(BaseListView view) {
        mYueDanView = view;
        mDataList = new ArrayList<YueDanBean.PlayListsBean>();
    }

    @Override
    public void loadDataList() {
        YueDanRequest.getYueDanRequest(0, mYueDanBeanNetworkListener).execute();
    }

    private NetworkListener<YueDanBean> mYueDanBeanNetworkListener = new NetworkListener<YueDanBean>() {
        @Override
        public void onFailed(String s) {
            mYueDanView.onDataLoadFailed(s);
        }

        @Override
        public void onSuccess(YueDanBean result) {
            mDataList.addAll(result.getPlayLists());
            //通知view层更新
            mYueDanView.onDataLoaded();
        }
    };

    @Override
    public void refresh() {
        mDataList.clear();
        loadDataList();
    }

    @Override
    public void loadMoreData() {
        YueDanRequest.getYueDanRequest(mDataList.size(), mYueDanBeanNetworkListener).execute();
    }

    @Override
    public List<YueDanBean.PlayListsBean> getDataList() {
        return mDataList;
    }
}
