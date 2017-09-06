package com.itheima.mvplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.itheima.mvplayer.widget.HomeListItemView;

/**
 * Created by Administrator on 2017/9/6.
 */

public class HomeListAdapter extends RecyclerView.Adapter {
    private Context mContext;

    public HomeListAdapter (Context context){
        mContext=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeListItemViewHolder(new HomeListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class HomeListItemViewHolder extends RecyclerView.ViewHolder{

        private HomeListItemViewHolder mHomeListItemViewHolder;

        public HomeListItemViewHolder(HomeListItemView itemView) {
            super(itemView);
        }
    }
}
