package com.yekong.common.baseadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by xigua on 2017/10/17.
 */

public abstract class BaseAdapter<M> extends RecyclerView.Adapter {
    public ItemClickListener<M> listener;
    public Context context;
    private List<M> list;

    public BaseAdapter(ItemClickListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    public void setList(List<M> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<M> getList(){return list;}

    @Override
    public int getItemViewType(int position) {
        return getViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(context,parent,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindView(holder,position,list.get(position));
    }

    @Override
    public int getItemCount() {
        return list == null?0:list.size();
    }
    public abstract RecyclerView.ViewHolder getViewHolder(Context context , ViewGroup parent , int viewType);
    public abstract void onBindView(RecyclerView.ViewHolder holder , int position , M m);
    public abstract int getViewType(int position);
}
