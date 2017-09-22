package com.itheima.mvplayer.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.itheima.mvplayer.model.MusicListItemBean;
import com.itheima.mvplayer.widget.MusicListItemView;

/**
 * Created by Administrator on 2017/9/21.
 */

public class MusicListCursorAdapter extends CursorAdapter {


    public MusicListCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return new MusicListItemView(context);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MusicListItemBean itemBean = MusicListItemBean.parseFromCursor(cursor);

        ((MusicListItemView)view).bindView(itemBean);
    }
}
