package com.yekong.kotlin_common.baseadapter

import android.view.View

/**
 * Created by xigua on 2017/10/19.
 */
interface ItemClickListener <M>{
    fun onItemClick(v : View, p : Int, m : M)
    fun onViewClick(id : Int , p : Int , m : M)
}