package com.itheima.mvplayer.network;

import com.google.gson.Gson;
import com.itheima.mvplayer.model.NetWorkManager;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/9/12.
 */

public class MVPlayerRequest<T> {

    public static final int DEFAULT_PAGE_SIZE=10;
    private String mUrl;
    private NetworkListener mNetworkListener;
    private Gson mGson;
    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public NetworkListener getNetworkListener() {
        return mNetworkListener;
    }

    public void setNetworkListener(NetworkListener networkListener) {
        mNetworkListener = networkListener;
    }

    public MVPlayerRequest(String url, NetworkListener listener){
            mUrl=url;
            mNetworkListener =listener;
            mGson= new Gson();
    }

    public void execute() {
        NetWorkManager.getInstance().sendRequest(this);
    }

    public T parseNetWorkRequest(String string) {
        Class aClass = getClass();
        Type genericSuperclass = aClass.getGenericSuperclass();

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        T result =mGson.fromJson(string,parameterizedType.getActualTypeArguments()[0]);
        return  result;
    }
}
