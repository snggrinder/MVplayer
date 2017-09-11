package com.itheima.mvplayer.presenter;

import com.itheima.mvplayer.model.HomeListItemBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11.
 */

public interface HomePresenter {
    void loadDataList();

    void refresh();

    void loadMoreData();

    List<HomeListItemBean> getDataList();
}
