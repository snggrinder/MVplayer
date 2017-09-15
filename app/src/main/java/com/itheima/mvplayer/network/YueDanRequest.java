package com.itheima.mvplayer.network;

import com.itheima.mvplayer.model.YueDanBean;
import com.itheima.mvplayer.utils.UrlProviderUtils;

/**
 * Created by Administrator on 2017/9/14.
 */

public class YueDanRequest extends MVPlayerRequest<YueDanBean> {


    public YueDanRequest(String url, NetWorkListener listener) {
        super(url, listener);
    }

    public static YueDanRequest getYueDanRequest(int offset,NetWorkListener listener){

        return  new YueDanRequest(UrlProviderUtils.getYueDanUrl(offset,DEFAULT_PAGE_SIZE),listener);
    }
}
