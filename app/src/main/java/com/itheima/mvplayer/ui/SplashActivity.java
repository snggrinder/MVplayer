package com.itheima.mvplayer.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.itheima.mvplayer.MainActivity;
import com.itheima.mvplayer.R;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/9/2.
 */

public class SplashActivity extends BaseActivity {
    @Bind(R.id.imageView)
    ImageView mImageView;

    @Override
    public int getLayoutResId() {

        return R.layout.activity_splash;
    }

    @Override
    public void init() {


        super.init();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        animation.setAnimationListener(mAnimationListener);
        mImageView.startAnimation(animation);
    }

    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
         @Override
         public void onAnimationStart(Animation animation) {

         }

         @Override
         public void onAnimationEnd(Animation animation) {
             goTo(MainActivity.class,true);

         }

         @Override
         public void onAnimationRepeat(Animation animation) {

         }
     };

}
