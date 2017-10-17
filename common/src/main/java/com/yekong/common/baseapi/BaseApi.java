package com.yekong.common.baseapi;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yekong.common.baseapp.BaseApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.yekong.common.constant.Constant.BASEURL;

/**
 * Created by xigua on 2017/10/17.
 */

public class BaseApi {


    private static BaseApi instance;
    private BaseApi() {
    }

    public static BaseApi getInstance() {
        if (instance == null) {
            instance = new BaseApi();
        }
        return instance;
    }

    private OkHttpClient okHttpClient;
    private static File cacheDirectory = new File(BaseApplication.getInstance().getCacheDir().getAbsolutePath(), "APP");
    private static Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
    public OkHttpClient getOkHttpClient(){
        if ( null == okHttpClient) {
            okHttpClient = new OkHttpClient()
                    .newBuilder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(chain -> {
                        Request request = chain.request()
                                .newBuilder()
                                .url(BASEURL)
                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                                .addHeader("Accept-Encoding", "gzip, deflate")
//                                .addHeader("Connection", "keep-alive")
//                                .addHeader("Accept", "*/*")
//                                .addHeader("Cookie", "key=value")
                                .build();
                        return chain.proceed(request);
                    })
                    .cache(cache)
                    .build();
        }
        return okHttpClient;
    }

    private static Retrofit apiAdapter;

    public Retrofit getApiAdapter(){
        if (null == apiAdapter){
            if (null == okHttpClient) okHttpClient = getOkHttpClient();
            apiAdapter = new Retrofit.Builder()
                    .baseUrl(BASEURL+"/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .client(getOkHttpClient())
                    .build();

        }
        return apiAdapter;
    }

}
