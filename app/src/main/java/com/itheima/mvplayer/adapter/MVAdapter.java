package com.itheima.mvplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.itheima.mvplayer.model.AreaBean;
import com.itheima.mvplayer.ui.fragment.MVPageFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */

public class MVAdapter extends FragmentStatePagerAdapter{

    public static final String TAG = "MVAdapter";

    private List<AreaBean> mAreaBeanList;

    public MVAdapter(FragmentManager fm, List<AreaBean> list) {
        super(fm);
        mAreaBeanList = list;
    }


    @Override
    public Fragment getItem(int position) {
        return MVPageFragment.newInstance(mAreaBeanList.get(position).getCode());
    }

    @Override
    public int getCount() {
        return mAreaBeanList.size();
    }

    /**
     * 返回TabLayout的标题
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mAreaBeanList.get(position).getName();
    }
}
