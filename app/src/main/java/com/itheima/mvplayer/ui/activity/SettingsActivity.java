package com.itheima.mvplayer.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.itheima.mvplayer.R;

/**
 * Created by Administrator on 2017/9/2.
 */

public class SettingsActivity extends BaseActivity {
    @Override
    public int getLayoutResId() {
        return R.layout.activity_settings;
    }


    @Override
    public void init() {


        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();

        supportActionBar.setTitle(R.string.settings);

        supportActionBar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
                    case android.R.id.home:
                        finish();
                        break;

                    default:
                        break;
                   }

        return super.onOptionsItemSelected(item);
    }
    public static class SettingsFragment extends PreferenceFragment{

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            addPreferencesFromResource(R.xml.settings_pref);
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {

            if(preference.getKey().equals("about")){
                Intent intent = new Intent(getActivity(),AboutActivity.class);

                startActivity(intent);
            }
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }



    }


}
