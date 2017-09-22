package com.itheima.mvplayer.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.itheima.mvplayer.adapter.HomeListAdapter;
import com.itheima.mvplayer.presenter.BaseListPresenter;
import com.itheima.mvplayer.presenter.impl.HomePresenterImpl;
import com.itheima.mvplayer.view.BaseListView;

/**
 * Created by Administrator on 2017/9/5.
 */

public class HomeFragment extends BaseListFragment {

    private HomePresenterImpl mHomePresenter;

    @Override
    protected BaseListPresenter getPresenter(BaseListView view) {
        mHomePresenter = new HomePresenterImpl(view);
        return mHomePresenter;
    }



    @Override
    public RecyclerView.Adapter getAdapter() {
        return new HomeListAdapter(getContext(), mHomePresenter.getDataList());
    }
}