package com.itheima.mvplayer.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.itheima.mvplayer.adapter.MVPageAdapter;
import com.itheima.mvplayer.presenter.BaseListPresenter;
import com.itheima.mvplayer.presenter.MVPagePresenter;
import com.itheima.mvplayer.view.BaseListView;

/**
 * Created by Administrator on 2017/9/21.
 */
public class MVPageFragment extends BaseListFragment{
    private String mCode;

    private MVPagePresenter mMVPagePresenter;


    public static MVPageFragment newInstance(String code) {
        MVPageFragment fragment = new MVPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("code", code);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        mCode = (String) arguments.get("code");
    }

    @Override
    public BaseListPresenter getPresenter(BaseListView listView) {
        mMVPagePresenter = new MVPagePresenter(listView, mCode);
        return mMVPagePresenter;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new MVPageAdapter(getContext(), mMVPagePresenter.getDataList());
    }
}
