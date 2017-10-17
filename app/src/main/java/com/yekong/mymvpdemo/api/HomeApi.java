package com.yekong.mymvpdemo.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * retrfit api 声明
 * Created by xigua on 2017/10/17.
 */

public interface HomeApi {
    @GET("/getData")
    Observable<String> getData();
    @GET("/userInfo")
    Observable<String> getUserInfo();
}
