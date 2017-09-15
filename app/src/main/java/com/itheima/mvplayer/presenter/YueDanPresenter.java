package com.itheima.mvplayer.presenter;

import com.itheima.mvplayer.model.YueDanBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public interface YueDanPresenter {

    void loadDataList();

    void refresh();

    void loadMoreData();


    List<YueDanBean.PlayListsBean> getDataList();
}
