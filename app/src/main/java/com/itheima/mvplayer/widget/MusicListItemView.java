package com.itheima.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.model.MusicListItemBean;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/21.
 */
public class MusicListItemView extends RelativeLayout {
    @Bind(R.id.music_list_icon)
    ImageView mMusicListIcon;
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.artist)
    TextView mArtist;
    @Bind(R.id.size)
    TextView mSize;

    public MusicListItemView(Context context) {
        this(context, null);
    }

    public MusicListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_music_list_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(MusicListItemBean musicListItemBean) {
        mTitle.setText(musicListItemBean.getTitle());
        mArtist.setText((musicListItemBean.getArtist()));

        mSize.setText(android.text.format.Formatter.formatFileSize(getContext(),musicListItemBean.getSize()));
    }
}
