package com.itheima.mvplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/9/2.
 */

public abstract class BaseActivity extends AppCompatActivity{

    public static final String TAG ="BaseActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();

    }

    public void init() {

    }

    public abstract int getLayoutResId() ;

    protected void goTo(Class activity ,boolean finish){

        Intent intent = new Intent(BaseActivity.this, activity);
        startActivity(intent);
        if(finish){
            finish();
        }


    }

}
