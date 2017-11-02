package com.yekong.kotlin_common.base

import android.content.Context

/**
 * Created by xigua on 2017/10/19.
 */
class BasePresenter<A : BaseAction , M : BaseModel> {
    var a : A = null!!
    var m : M = null!!
    var context : Context = null!!

    fun setPresenter(a : A, m : M ,c : Context){
        this.a = a
        this.m = m
        this.context = c
    }
}