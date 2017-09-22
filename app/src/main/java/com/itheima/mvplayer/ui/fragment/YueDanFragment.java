package com.itheima.mvplayer.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.itheima.mvplayer.adapter.YueDanAdapter;
import com.itheima.mvplayer.presenter.BaseListPresenter;
import com.itheima.mvplayer.presenter.impl.YueDanPresenterImpl;
import com.itheima.mvplayer.view.BaseListView;

/**
 * Created by Administrator on 2017/9/5.
 */

public class YueDanFragment extends BaseListFragment{

    private YueDanPresenterImpl mYueDanPresenter;
    @Override
    protected BaseListPresenter getPresenter(BaseListView listView) {
        mYueDanPresenter = new YueDanPresenterImpl(listView);
        return mYueDanPresenter;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new YueDanAdapter(getContext(), mYueDanPresenter.getDataList());
    }
}
