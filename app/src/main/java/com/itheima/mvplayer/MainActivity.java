package com.itheima.mvplayer;

import android.view.Menu;
import android.view.MenuItem;

import com.itheima.mvplayer.ui.BaseActivity;
import com.itheima.mvplayer.ui.SettingsActivity;

public class MainActivity extends BaseActivity{


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                goTo(SettingsActivity.class,false);

                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
