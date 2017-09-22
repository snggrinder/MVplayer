package com.itheima.mvplayer.presenter;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public interface BaseListPresenter<T> {


    void loadDataList();

    void refresh();

    void loadMoreData();

    List<T> getDataList();
}
