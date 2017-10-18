package com.yekong.mymvpdemo.api;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * retrfit api 声明
 * Created by xigua on 2017/10/17.
 */

public interface HomeApi {
    @GET("/getData")
    Observable<String> getData();
    @GET("/userInfo")
    Observable<String> getUserInfo();

    @Multipart
    @POST("")
    Observable<String > upload(@Part("key") String value , @Part List<MultipartBody.Part> body);
}
