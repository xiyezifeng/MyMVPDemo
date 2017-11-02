package com.yekong.kotlin_common.baseservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.yekong.kotlin_common.constant.Constant

/**
 * Created by xigua on 2017/10/19.
 */
class NetService : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if (p1!!.action.equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            var status = netStatus(p0!!)

        }
    }
    fun netStatus(ctx : Context):Int{
        var connectivityManager = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo = connectivityManager.activeNetworkInfo
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
            if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                return Constant.NET_WLAN
            } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                return Constant.NET_WAP
            }
        }else{
            return Constant.NETWORK_NONE
        }
        return Constant.NETWORK_NONE
    }

 }