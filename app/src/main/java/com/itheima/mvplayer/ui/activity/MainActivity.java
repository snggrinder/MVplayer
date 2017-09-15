package com.itheima.mvplayer.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.factory.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.Bind;

public class MainActivity extends BaseActivity {


    @Bind(R.id.bottom_bar)
    BottomBar mBottomBar;
    private FragmentManager mSupportFragmentManager;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void init() {
        mSupportFragmentManager = getSupportFragmentManager();
        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                goTo(SettingsActivity.class, false);

                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    private OnTabSelectListener mOnTabSelectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId) {

            FragmentTransaction fragmentTransaction = mSupportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(tabId));
            fragmentTransaction.commit();
        }
    };
}
