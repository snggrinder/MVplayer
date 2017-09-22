package com.itheima.mvplayer.presenter;

import android.util.Log;

import com.itheima.mvplayer.model.MVPageBean;
import com.itheima.mvplayer.network.MVPageRequest;
import com.itheima.mvplayer.network.NetworkListener;
import com.itheima.mvplayer.view.BaseListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public class MVPagePresenter implements BaseListPresenter<MVPageBean.VideosBean> {

    public static final String TAG ="MVPagePresenter";
    private BaseListView mBaseListView;
    private String mArea;

    private List<MVPageBean.VideosBean> mDataList;

    public MVPagePresenter(BaseListView view, String area) {
        mBaseListView = view;
        mArea = area;
        mDataList = new ArrayList<MVPageBean.VideosBean>();
    }

    @Override
    public void loadDataList() {
        Log.d(TAG, "loadDataList: ");
        MVPageRequest.getMVPageRequest(mArea, 0, mNetworkListener).execute();
    }

    @Override
    public void refresh() {
        mDataList.clear();
        loadDataList();
    }

    @Override
    public void loadMoreData() {
        MVPageRequest.getMVPageRequest(mArea, mDataList.size(), mNetworkListener).execute();
    }

    @Override
    public List<MVPageBean.VideosBean> getDataList() {
        return mDataList;
    }

    private NetworkListener<MVPageBean> mNetworkListener = new NetworkListener<MVPageBean>() {
        @Override
        public void onFailed(String s) {
            Log.d(TAG, "onFailed: " + s);
        }

        @Override
        public void onSuccess(MVPageBean result) {
            mDataList.addAll(result.getVideos());
            mBaseListView.onDataLoaded();
        }


    };
}
