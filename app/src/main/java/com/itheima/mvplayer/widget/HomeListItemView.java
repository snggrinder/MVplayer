package com.itheima.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.itheima.mvplayer.R;

/**
 * Created by Administrator on 2017/9/6.
 */

public class HomeListItemView extends RelativeLayout {
    public HomeListItemView(Context context) {
       this(context,null);
    }

    public HomeListItemView(Context context, AttributeSet attrs) {

        super(context, attrs);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_home_list_item,this);
    }
}
