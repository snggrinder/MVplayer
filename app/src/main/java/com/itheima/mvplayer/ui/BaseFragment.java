package com.itheima.mvplayer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/2.
 */

public abstract class BaseFragment extends Fragment {

    public final static String TAG="BaseFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(getLayoutId(),null);
        ButterKnife.bind(this,root);
        init();

        //测试github\
        Log.e(TAG, "onCreateView: ", new Exception());

        return root;
    }

    public void init() {

    }

    protected abstract int getLayoutId() ;
}
