package com.itheima.mvplayer.ui.fragment;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.MusicListCursorAdapter;
import com.itheima.mvplayer.utils.MusicQueryHandler;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/5.
 */

public class VbangFragment extends BaseFragment {
    public static final String TAG = "HomeFragment";

    @Bind(R.id.list_view)
    ListView mListView;

//    private MusicListAdapter mMusicListAdapter;

    private MusicListCursorAdapter mMusicListAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_vbang;
    }

    @Override
    protected void init() {
        super.init();
        mMusicListAdapter = new MusicListCursorAdapter(getContext(), null, false);
        mListView.setAdapter(mMusicListAdapter);
        //查询手机数据库
        loadMusic();
    }

    private void loadMusic() {
        ContentResolver resolver = getContext().getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.SIZE,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.DATA};//DATA是音频文件的路径
//        Cursor query = resolver.query(uri, projection, null, null, null);
//        PrintCursorUtils.printCursor(query);
        MusicQueryHandler musicQueryHandler = new MusicQueryHandler(resolver);
        //token 标记查询
        musicQueryHandler.startQuery(0, mMusicListAdapter, uri, projection, null, null, null);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}