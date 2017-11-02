package com.yekong.kotlin_common.baseapi

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by xigua on 2017/10/19.
 */
class BaseApi private constructor(){
    companion object{
        var instance= BaseApi()
    }

    /**
     * val 修饰常量
     * var 修饰变量
     */
    val BASE_URL = "9999"

    var okhttp : OkHttpClient = null!!
    fun getHttpClick():OkHttpClient{
        if (okhttp == null) {
            okhttp = OkHttpClient()
                    .newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor({ chain: Interceptor.Chain? ->
                        var re = chain!!.request()
                                .newBuilder()
                                .url(BASE_URL)
                                .build()
                        chain.proceed(re)
                    })
                    .build()
        }
        return okhttp
    }
    var retrofit : Retrofit = null!!
    fun getRetrofitClick():Retrofit{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(getHttpClick())
                    .build()
        }
        return retrofit
    }



}