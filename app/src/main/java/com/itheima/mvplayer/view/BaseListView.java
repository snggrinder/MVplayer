package com.itheima.mvplayer.view;

/**
 * Created by Administrator on 2017/9/20.
 */

public interface BaseListView {
    void onDataLoaded();

    void onDataLoadFailed(String error);
}
