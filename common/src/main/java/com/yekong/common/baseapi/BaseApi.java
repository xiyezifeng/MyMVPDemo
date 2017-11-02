package com.yekong.common.baseapi;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yekong.common.baseapp.BaseApplication;
import com.zxy.tiny.Tiny;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
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
//                    .addInterceptor(chain -> {
//                        Request request = chain.request()
//                                .newBuilder()
//                                .url(BASEURL)
//                                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
////                                .addHeader("Accept-Encoding", "gzip, deflate")
////                                .addHeader("Connection", "keep-alive")
////                                .addHeader("Accept", "*/*")
////                                .addHeader("Cookie", "key=value")
//                                .build();
//                        return chain.proceed(request);
//                    })
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

    /**
     * 文件上传模板
     */
    public void uploadFile(ArrayList<String> files ,OnParamsCallback callback){
        final MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);//表单类型
        /*if (params != null) {
//            builder.addFormDataPart("data", buildParams(api,params));//ParamKey.TOKEN 自定义参数key常量类，即参数名
            Set<String> keys = params.keySet();
            Iterator<String > iterator = keys.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = params.get(key);
                builder.addFormDataPart(key,value);
            }
        }*/
        Tiny.FileCompressOptions options = new Tiny.FileCompressOptions();
        String[] fs = new String[files.size()];
        for (int i = 0; i < files.size(); i++) {
            fs[i] = files.get(i);
        }
        if (files.size() > 0) {
            //压缩
            Tiny.getInstance().source(fs).batchAsFile().withOptions(options).batchCompress((isSuccess, outfile) -> {
                if (isSuccess) {
                    int i1 = 0;
                    for (String path1 : outfile) {
                        File file = new File(path1);
                        builder.addFormDataPart("files" + i1, file.getName(), RequestBody.create(MediaType.parse("*/*"), file));
                        i1++;
                    }
                    callback.onCallBack(builder.build().parts());
                }else{
                    callback.onCallBack(null);
                }
            });
        }
    }
    public interface OnParamsCallback{
        void onCallBack(List<MultipartBody.Part> body);
    }

    public void setOkHttpClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public static void setRetrofit(Retrofit apiAdapter) {
        BaseApi.apiAdapter = apiAdapter;
    }
}
