package com.yekong.mymvpdemo.api;

import com.yekong.common.baseapi.BaseApi;

/**
 * Created by xigua on 2017/10/17.
 */

public class Api {
    private static HomeApi homeApi;
    public static HomeApi homeApi(){
        if (null == homeApi)
            homeApi =  BaseApi.getInstance().getApiAdapter().create(HomeApi.class);
        return homeApi;
    }
}
