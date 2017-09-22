package com.itheima.mvplayer.utils;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;

import com.itheima.mvplayer.adapter.MusicListCursorAdapter;
import com.itheima.mvplayer.model.MusicListItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/22.
 */

public class MusicQueryHandler extends AsyncQueryHandler {
    public static final String TAG = "MusicQueryHandler";

    private List<MusicListItemBean> mMusicListItemBeanList;

    public MusicQueryHandler(ContentResolver cr) {
        super(cr);
        mMusicListItemBeanList  = new ArrayList<MusicListItemBean>();
    }

    /**
     * 查询结束的回调
     * @param token 通过token区分查询请求
     * @param cookie 传递查询时传入的对象
     * @param cursor
     */
    @Override
    protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
        Log.d(TAG, "onQueryComplete: ");
        //将cursor遍历转换list集合
        while (cursor.moveToNext()) {
            MusicListItemBean listItem = MusicListItemBean.parseFromCursor(cursor);
            mMusicListItemBeanList.add(listItem);
        }
        MusicListCursorAdapter musicListAdapter = (MusicListCursorAdapter) cookie;
        musicListAdapter.swapCursor(cursor);
    }
}