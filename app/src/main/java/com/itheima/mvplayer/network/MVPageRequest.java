package com.itheima.mvplayer.network;

import com.itheima.mvplayer.model.MVPageBean;
import com.itheima.mvplayer.utils.UrlProviderUtils;

/**
 * Created by Administrator on 2017/9/21.
 */
public class MVPageRequest extends MVPlayerRequest<MVPageBean>{
    public MVPageRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
    public static MVPageRequest getMVPageRequest(String area, int offset, NetworkListener listener) {
        return new MVPageRequest(UrlProviderUtils.getMVListUrl(area, offset, DEFAULT_PAGE_SIZE), listener);
    }
}
