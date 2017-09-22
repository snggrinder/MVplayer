package com.itheima.mvplayer.network;

import com.itheima.mvplayer.model.HomeListItemBean;
import com.itheima.mvplayer.utils.UrlProviderUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/9/12.
 */

public class HomeRequest extends MVPlayerRequest<List<HomeListItemBean>>{

    public HomeRequest(String url, NetworkListener listener) {
        super(url, listener);
    }

    public static HomeRequest getHomeRequest(int offset,NetworkListener listener){
        return  new HomeRequest(UrlProviderUtils.getHomeUrl(offset,DEFAULT_PAGE_SIZE),listener);
    }
}
