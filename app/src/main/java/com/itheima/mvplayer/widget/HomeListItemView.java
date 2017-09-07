package com.itheima.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.mvplayer.R;
import com.itheima.mvplayer.model.HomeListItemBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/6.
 */

public class HomeListItemView extends RelativeLayout {
    @Bind(R.id.mv_img)
    ImageView mMvImg;
    @Bind(R.id.home_page_icon)
    ImageView mHomePageIcon;
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.description)
    TextView mDescription;

    public HomeListItemView(Context context) {
        this(context, null);
    }

    public HomeListItemView(Context context, AttributeSet attrs) {

        super(context, attrs);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_home_list_item, this);
        ButterKnife.bind(this,this);

    }

    public void bindView(HomeListItemBean homeListItemBean) {
        mTitle.setText(homeListItemBean.getTitle());
        mDescription.setText(homeListItemBean.getDescription());
        Glide.with(getContext()).load(homeListItemBean.getPosterPic()).centerCrop().into(mMvImg);

    }
}
