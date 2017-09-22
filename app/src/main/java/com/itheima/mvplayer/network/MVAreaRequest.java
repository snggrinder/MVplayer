package com.itheima.mvplayer.network;

import com.itheima.mvplayer.model.AreaBean;
import com.itheima.mvplayer.utils.UrlProviderUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MVAreaRequest extends MVPlayerRequest<List<AreaBean>> {
    public MVAreaRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
    public static MVAreaRequest getMVAreaRequest(NetworkListener listener) {
        return new MVAreaRequest(UrlProviderUtils.getMVareaUrl(), listener);
    }
}
