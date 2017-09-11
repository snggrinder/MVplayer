package com.itheima.mvplayer.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.HomeListAdapter;
import com.itheima.mvplayer.presenter.HomePresenter;
import com.itheima.mvplayer.presenter.impl.HomePresenterImpl;
import com.itheima.mvplayer.view.HomeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/5.
 */

public class HomeFragment extends BaseFragment implements HomeView{
    public static final String TAG = "HomeFragment";
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
   // private Gson mGson;

   // private Handler mHandler = new Handler(Looper.getMainLooper());
    //private List<HomeListItemBean> mListData;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private HomeListAdapter mHomeListAdapter;

    //持有一个Presenter的引用
    private HomePresenter mHomePresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void init() {

        mHomePresenter = new HomePresenterImpl(this);

        //mGson = new Gson();
        initRecyclerView();

        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        //调用P层去加载数据
        mHomePresenter.loadDataList();

    }


        SwipeRefreshLayout.OnRefreshListener mOnRefreshListener =new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                //刷新调用p层
                mHomePresenter.refresh();
            }
        };


    private void initRecyclerView() {
        mHomeListAdapter = new HomeListAdapter(getContext(), mHomePresenter.getDataList());

        //设置RecyclerView有固定大小，内部会做优化
        mRecyclerView.setHasFixedSize(true);
        //设置布局管理器，一定要设置，否则看不到条目
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecyclerView.setAdapter(mHomeListAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
    }

    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            //判断是否处于idle状态
            if(newState==RecyclerView.SCROLL_STATE_IDLE){
                //判断是否滑到底
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                if(lastVisibleItemPosition==mHomePresenter.getDataList().size()-1){
                    //调用P层数据
                    mHomePresenter.loadMoreData();
                }
            }
            super.onScrollStateChanged(recyclerView, newState);

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDataLoaded() {

        mSwipeRefreshLayout.setRefreshing(false);
        mHomeListAdapter.notifyDataSetChanged();
        Toast.makeText(getContext(),"加载数据",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDataLoadedFaild(String str) {

    }
}
