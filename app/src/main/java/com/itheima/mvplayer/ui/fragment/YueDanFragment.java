package com.itheima.mvplayer.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.YueDanAdapter;
import com.itheima.mvplayer.presenter.YueDanPresenter;
import com.itheima.mvplayer.presenter.impl.YueDanPresenterImp;
import com.itheima.mvplayer.view.YueDanView;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/9/5.
 */

public class YueDanFragment extends BaseFragment implements YueDanView{

    private YueDanAdapter mYueDanAdapter;

    private YueDanPresenter mYueDanPresenter;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yue_dan;
    }


    @Override
    public void init() {
        super.init();
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mYueDanPresenter = new YueDanPresenterImp(this);
        initRecyclerView();
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);
        mYueDanPresenter.loadDataList();
        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }

     private     SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
         @Override
         public void onRefresh() {
             mYueDanPresenter.refresh();

             mSwipeRefreshLayout.setRefreshing(false);
         }
     };
        private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                    if(layoutManager.findLastVisibleItemPosition()==mYueDanPresenter.getDataList().size()-1){
                        mYueDanPresenter.loadMoreData();
                    }
                }
            }
        };

    private void initRecyclerView() {


        mYueDanAdapter= new YueDanAdapter(getContext(),mYueDanPresenter.getDataList());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mYueDanAdapter);
    }

    @Override
    public void onDataLoaded() {
        mYueDanAdapter.notifyDataSetChanged();
    }

    @Override

    public void onDataLoadedFailed(String s) {
        Log.d(TAG, "onDataLoadedFailed: "+s);
    }

}
