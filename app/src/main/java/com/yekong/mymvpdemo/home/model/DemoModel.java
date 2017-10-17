package com.yekong.mymvpdemo.home.model;

import android.util.Log;

import com.yekong.common.rxutils.RxUtils;
import com.yekong.mymvpdemo.api.Api;
import com.yekong.mymvpdemo.home.constitute.DemoBarConstitute;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xigua on 2017/10/16.
 */

public class DemoModel extends DemoBarConstitute.Model{
    @Override
    public Observable<String> model(){
        Log.e("DemoModel", "model");
        return RxUtils.createObserver(Api.homeApi().getData(), context, true, null);
    }
    @Override
    public Observable<String> getList(){
        return Observable.just("hello world")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        ;
    }

    @Override
    public Observable<String> getUserInfo() {
        return RxUtils.createObserver(Api.homeApi().getUserInfo(), context, true, "获取用户信息...");
    }
}
