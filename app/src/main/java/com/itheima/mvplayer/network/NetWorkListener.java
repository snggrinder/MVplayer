package com.itheima.mvplayer.network;

/**
 * Created by Administrator on 2017/9/12.
 */

public interface NetworkListener<T> {
    void onFailed(String s);

    /**
     * 回调解析后的结果
     * @param result
     */
    void onSuccess(T result);
}
