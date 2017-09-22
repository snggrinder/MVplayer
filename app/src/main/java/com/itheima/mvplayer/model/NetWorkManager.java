package com.itheima.mvplayer.model;

import android.os.Handler;
import android.os.Looper;

import com.itheima.mvplayer.network.MVPlayerRequest;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/12.
 */

public   class NetWorkManager {

    public static  NetWorkManager sNetWorkManager;

    private OkHttpClient mOkHttpClient;

    private Handler mHandler = new Handler(Looper.getMainLooper());
    private NetWorkManager(){
        mOkHttpClient =new OkHttpClient();
    }

    public static NetWorkManager getInstance(){
        if(sNetWorkManager==null){
            synchronized (NetWorkManager.class){
                if(sNetWorkManager==null){
                    sNetWorkManager=new NetWorkManager();
                }
            }
        }

        return  sNetWorkManager;
    }

    public void sendRequest(final MVPlayerRequest mvPlayerRequest){
        Request request = new Request.Builder().url(mvPlayerRequest.getUrl()).get().build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvPlayerRequest.getNetworkListener().onFailed(e.getLocalizedMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
             //解析结果在子线程

               final Object o = mvPlayerRequest.parseNetWorkRequest(response.body().string());

                // 回调网络请求成功，传入解析后的结果

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvPlayerRequest.getNetworkListener().onSuccess(o);
                    }
                });
            }
        });
    }
}
