package com.itheima.mvplayer.ui;

import android.support.v7.app.ActionBar;

import com.itheima.mvplayer.R;

/**
 * Created by Administrator on 2017/9/6.
 */
public class AboutActivity extends BaseActivity{
    @Override
    public int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    public void init() {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(R.string.about);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
}
