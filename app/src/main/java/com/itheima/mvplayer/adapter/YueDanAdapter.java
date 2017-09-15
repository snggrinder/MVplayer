package com.itheima.mvplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.itheima.mvplayer.model.YueDanBean;
import com.itheima.mvplayer.widget.YueDanListItemView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class YueDanAdapter extends RecyclerView.Adapter<YueDanAdapter.YueDanListItemViewHolder>{

    private Context mContext;

    private List<YueDanBean.PlayListsBean> mPlayListsBeen;
    public YueDanAdapter(Context context,List<YueDanBean.PlayListsBean> list){
        mContext=context;
        mPlayListsBeen=list;
    }
    @Override
    public YueDanAdapter.YueDanListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YueDanListItemViewHolder(new YueDanListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(YueDanAdapter.YueDanListItemViewHolder holder, int position) {
         holder.mYueDanListItemView.bindView(mPlayListsBeen.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayListsBeen.size();
    }

    public class YueDanListItemViewHolder extends RecyclerView.ViewHolder{

        private YueDanListItemView mYueDanListItemView;
        public YueDanListItemViewHolder(YueDanListItemView itemView) {
            super(itemView);
            mYueDanListItemView=itemView;
        }
    }
}
