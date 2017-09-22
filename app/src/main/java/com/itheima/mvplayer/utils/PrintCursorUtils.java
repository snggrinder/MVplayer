package com.itheima.mvplayer.utils;

import android.database.Cursor;
import android.util.Log;

/**
 * Created by Administrator on 2017/9/22.
 */

public class PrintCursorUtils {
    public static final String TAG = "PrintCursorUtils";

    public static void printCursor(Cursor cursor) {
        while (cursor.moveToNext()) {
            for (int i = 0; i < cursor.getColumnCount(); i++) {
                Log.d(TAG, "printCursor: " + cursor.getColumnName(i) +":" + cursor.getString(i));

            }
            Log.d(TAG, "printCursor: ------------------------------------");
        }

    }
}