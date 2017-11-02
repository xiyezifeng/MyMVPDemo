package com.yekong.kotlin_common.baseapp

import android.app.Application

/**
 * Created by xigua on 2017/10/19.
 */
class BaseApplication : Application() {
    companion object{
        var instance  = this
    }
    override fun onCreate() {
        super.onCreate()

    }
}