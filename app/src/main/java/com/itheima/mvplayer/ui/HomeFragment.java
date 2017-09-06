package com.itheima.mvplayer.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.HomeListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/5.
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private HomeListAdapter mHomeListAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        mHomeListAdapter= new HomeListAdapter(getContext());

        //设置RecyclerView有固定大小，内部会做优化
        mRecyclerView.setHasFixedSize(true);
        //设置布局管理器，一定要设置，否则看不到条目
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerView.setAdapter(mHomeListAdapter);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
