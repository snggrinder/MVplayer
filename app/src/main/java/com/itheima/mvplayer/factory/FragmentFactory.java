package com.itheima.mvplayer.factory;

import android.support.v4.app.Fragment;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.ui.fragment.HomeFragment;
import com.itheima.mvplayer.ui.fragment.MvFragment;
import com.itheima.mvplayer.ui.fragment.VbangFragment;
import com.itheima.mvplayer.ui.fragment.YueDanFragment;

/**
 * Created by Administrator on 2017/9/5.
 */

public class FragmentFactory {

    public static FragmentFactory sFragmentFactory;

    public VbangFragment mVbangFragment;


    public YueDanFragment mYueDanFragment;
    public MvFragment mMvFragment;
    public HomeFragment mHomeFragment;
    private FragmentFactory(){}
    public static FragmentFactory getInstance(){

        if(sFragmentFactory==null){
            synchronized (FragmentFactory.class){
                if(sFragmentFactory==null){
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }

        return  sFragmentFactory;
    }

    public Fragment getFragment (int tabId){
        switch (tabId) {
                    case R.id.tab_home:
                        return getHomeFragment();

            case R.id.tab_mv:
                        return getMvFragment();

            case R.id.tab_vbang:
                        return getVbangFragment();

            case R.id.tab_yue_dan:
                        return getYueDanFragment();


                   }
            return  null;
    }

    private Fragment getYueDanFragment() {

        if(mYueDanFragment==null){
            mYueDanFragment = new YueDanFragment();
        }
        return  mYueDanFragment;
    }

    private Fragment getVbangFragment() {
        if(mVbangFragment==null){
            mVbangFragment= new VbangFragment();
        }
        return mVbangFragment;
    }

    public Fragment getMvFragment() {

        if(mMvFragment==null){
            mMvFragment = new MvFragment();
        }
        return mMvFragment;
    }

    public Fragment getHomeFragment() {

        if(mHomeFragment==null){
            mHomeFragment = new HomeFragment();

        }
        return mHomeFragment;
    }
}
