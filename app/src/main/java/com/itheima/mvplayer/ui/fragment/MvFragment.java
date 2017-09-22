package com.itheima.mvplayer.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.MVAdapter;
import com.itheima.mvplayer.model.AreaBean;
import com.itheima.mvplayer.network.MVAreaRequest;
import com.itheima.mvplayer.network.NetworkListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/5.
 */

public class MvFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";
    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;


    private MVAdapter mMVAdapter;

    private List<AreaBean> mListData;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_mv;
    }

    @Override
    protected void init() {
        super.init();
        mListData = new ArrayList<AreaBean>();
        mMVAdapter = new MVAdapter(getChildFragmentManager(), mListData);
        mViewPager.setAdapter(mMVAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        loadAreaData();
    }

    private void loadAreaData() {
        MVAreaRequest.getMVAreaRequest(mListNetworkListener).execute();
    }

    private NetworkListener<List<AreaBean>> mListNetworkListener = new NetworkListener<List<AreaBean>>() {
        @Override
        public void onFailed(String s) {

        }

        @Override
        public void onSuccess(List<AreaBean> result) {
            mListData.addAll(result);
            mMVAdapter.notifyDataSetChanged();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
