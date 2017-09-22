package com.itheima.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.mvplayer.R;
import com.itheima.mvplayer.model.MVPageBean;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MVPageListItemView extends RelativeLayout {
    public static final String TAG = "MVPageListItemView";
    @Bind(R.id.mv_img)
    ImageView mMvImg;
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.artist)
    TextView mArtist;


    public MVPageListItemView(Context context) {
        this(context, null);
    }

    public MVPageListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.view_mv_page_list_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(MVPageBean.VideosBean videosBean) {
        Glide.with(getContext()).load(videosBean.getPosterPic()).centerCrop().into(mMvImg);
        mTitle.setText(videosBean.getTitle());
        mArtist.setText(videosBean.getArtistName());
    }
}

