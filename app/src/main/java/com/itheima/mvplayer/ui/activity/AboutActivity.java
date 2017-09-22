package com.itheima.mvplayer.ui.activity;

import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.itheima.mvplayer.R;

/**
 * Created by Administrator on 2017/9/6.
 */
public class AboutActivity extends BaseActivity {
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
