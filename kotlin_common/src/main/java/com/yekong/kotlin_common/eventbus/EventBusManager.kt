package com.yekong.kotlin_common.eventbus

import org.greenrobot.eventbus.EventBus

/**
 * Created by xigua on 2017/10/19.
 */
class EventBusManager {

    companion object{
        fun postEvent(event:Int){
            EventBus.getDefault().post(event)
        }
        fun postEvent(obj:Any){
            EventBus.getDefault().post(obj)
        }
        fun register(obj:Any){
            if (!EventBus.getDefault().isRegistered(obj)) {
                EventBus.getDefault().register(obj)
            }
        }
        fun unregister(obj: Any){
            if (EventBus.getDefault().isRegistered(obj)) {
                EventBus.getDefault().unregister(obj)
            }
        }
    }
}