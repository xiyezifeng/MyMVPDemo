package com.yekong.kotlin_common.baseentity

import com.alibaba.fastjson.JSON

/**
 * Created by xigua on 2017/10/19.
 */
class BaseEntity {
    var data : String = null!!
    var errorCode : Int = null!!
    var errorInfo : String = null!!
    fun <T> getEntity (cls : Class<T>) : T{
        return JSON.parseObject(data,cls)
    }
    fun <T> getEntityList (cls : Class<T>) : List<T>{
        return JSON.parseArray(data,cls)
    }

    override fun toString(): String {
        return JSON.toJSONString(this)
    }
}