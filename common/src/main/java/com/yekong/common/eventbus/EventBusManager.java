package com.yekong.common.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * 定义全局事件总线
 * 模块许自己定义消息类型
 * Created by xigua on 2017/10/17.
 */

public class EventBusManager {
    /**
     * 用户登录成功
     */
    public static final int EVENT_1 = 0x10000;
    /**
     * 用户注销
     */
    public static final int EVENT_2 = 0x10001;

    /**
     * 网络状态
     */
    public static final int NET_NO = 0x200001;
    public static final int NET_WAP = 0x200002;
    public static final int NET_WLAN = 0x200003;

    public static void postEvent(int event){
        EventBus.getDefault().post(Integer.valueOf(event));
    }
    public static void poptEvent(Object object){
        EventBus.getDefault().post(object);
    }
    public static void register(Object object){
        if (!EventBus.getDefault().isRegistered(object))
            EventBus.getDefault().register(object);
    }
    public static void unregister(Object object){
        if (EventBus.getDefault().isRegistered(object))
            EventBus.getDefault().unregister(object);
    }
}
