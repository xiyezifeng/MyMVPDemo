package com.yekong.kotlin_common.baseadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by xigua on 2017/10/19.
 */
abstract class BaseAdapter <M>(var context: Context, var listener: ItemClickListener<M>, var list: List<M>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        onBind(holder,position,list.get(position))
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return if (list == null) 0 else list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
       return getHolder()
    }

    override fun getItemViewType(position: Int): Int {
        return getType()
    }

    fun setData(list: List<M>){
        this.list = list
        notifyDataSetChanged()
    }

    abstract fun getHolder():RecyclerView.ViewHolder
    abstract fun onBind(holder: RecyclerView.ViewHolder, position: Int,m : M)
    abstract fun getType():Int

}