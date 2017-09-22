package com.itheima.mvplayer.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.itheima.mvplayer.R;
import com.itheima.mvplayer.adapter.MVPlayerPageAdapter;
import com.itheima.mvplayer.app.Constant;

import butterknife.Bind;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class MVPlayerActivity extends BaseActivity {
    public static final String TAG = "MVPlayerActivity";
    @Bind(R.id.jie_cao_player)
    fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard mJieCaoPlayer;
    @Bind(R.id.description)
    RadioButton mDescription;
    @Bind(R.id.comment)
    RadioButton mComment;
    @Bind(R.id.relative_mv)
    RadioButton mRelativeMv;
    @Bind(R.id.radio_group)
    RadioGroup mRadioGroup;
    @Bind(R.id.view_pager)
    ViewPager mViewPager;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_mv_player;
    }

    @Override
    public void init() {
        super.init();
        String title = getIntent().getStringExtra(Constant.Extra.MV_TITLE);
        String url = getIntent().getStringExtra(Constant.Extra.MV_URL);
        mJieCaoPlayer.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);

        mRadioGroup.check(R.id.description);
        mViewPager.setAdapter(new MVPlayerPageAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRadioGroup.check(R.id.description);
                    break;
                case 1:
                    mRadioGroup.check(R.id.comment);
                    break;
                case 2:
                    mRadioGroup.check(R.id.relative_mv);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.description:
                    mViewPager.setCurrentItem(0);
                    break;
                case R.id.comment:
                    mViewPager.setCurrentItem(1);
                    break;
                case R.id.relative_mv:
                    mViewPager.setCurrentItem(2);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
