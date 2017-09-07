package com.itheima.mvplayer.ui;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.HomeListAdapter;
import com.itheima.mvplayer.model.HomeListItemBean;
import com.itheima.mvplayer.utils.UrlProviderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/5.
 */

public class HomeFragment extends BaseFragment {
    public static final String TAG= "HomeFragment";
    private Gson mGson;

    private Handler mHandler= new Handler(Looper.getMainLooper());
    private List<HomeListItemBean> mListData;
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private HomeListAdapter mHomeListAdapter;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void init() {
        mListData = new ArrayList<>();
        mGson = new Gson();
        initRecyclerView();
        loadHomeData();


    }

    private void loadHomeData() {
        Request request = new Request.Builder().url(UrlProviderUtils.getHomeUrl(0,10)).get().build();
        OkHttpClient httpClient= new OkHttpClient();
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Log.d(TAG, "onResponse:------------------------------------------------------- "+response.body().string());
                List<HomeListItemBean> list = mGson.fromJson(response.body().string(), new TypeToken<List<HomeListItemBean>>() {
                }.getType());
                mListData.addAll(list);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mHomeListAdapter.notifyDataSetChanged();
                    }
                });

            }
        });
    }

    private void initRecyclerView() {
        mHomeListAdapter= new HomeListAdapter(getContext(),mListData);

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
