package com.itheima.mvplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.itheima.mvplayer.model.HomeListItemBean;
import com.itheima.mvplayer.widget.HomeListItemView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6.
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeListItemViewHolder> {
    private Context mContext;
    private List<HomeListItemBean> mListData;

    public HomeListAdapter (Context context){
        mContext=context;
    }

    public HomeListAdapter(Context context, List<HomeListItemBean> listData) {
        mContext=context;
        mListData=listData;
    }

    @Override
    public HomeListAdapter.HomeListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeListItemViewHolder(new HomeListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(HomeListAdapter.HomeListItemViewHolder holder, int position) {
        holder.mHomeListItemView.bindView(mListData.get(position));
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public class HomeListItemViewHolder extends RecyclerView.ViewHolder{

        private HomeListItemView mHomeListItemView;

        public HomeListItemViewHolder(HomeListItemView itemView) {
            super(itemView);
            mHomeListItemView =itemView;
        }



    }
}
