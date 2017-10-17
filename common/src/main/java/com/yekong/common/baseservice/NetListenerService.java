package com.yekong.common.baseservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.yekong.common.eventbus.EventBusManager;

/**
 * Created by xigua on 2017/10/17.
 */

public class NetListenerService extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = getNetWorkState(context);
            // 接口回调传过去状态的类型
            EventBusManager.postEvent(netWorkState);
        }
    }
    /**
     * 没有连接网络
     */
    private static final int NETWORK_NONE = EventBusManager.NET_NO;
    /**
     * 移动网络
     */
    private static final int NETWORK_MOBILE = EventBusManager.NET_WAP;
    /**
     * 无线网络
     */
    private static final int NETWORK_WIFI = EventBusManager.NET_WLAN;

    public static int getNetWorkState(Context context) {
        // 得到连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {

            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
//                Toast.makeText(context, "已链接至网络", Toast.LENGTH_SHORT).show();
                return NETWORK_WIFI;
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
//                Toast.makeText(context, "已链接至网络", Toast.LENGTH_SHORT).show();
                return NETWORK_MOBILE;
            }
        }else{
//            Toast.makeText(context, "网络已断开", Toast.LENGTH_SHORT).show();
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }
}
