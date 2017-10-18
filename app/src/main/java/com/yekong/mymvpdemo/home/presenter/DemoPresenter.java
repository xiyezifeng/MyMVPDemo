package com.yekong.mymvpdemo.home.presenter;

import android.util.Log;

import com.yekong.common.baseentity.BaseEntity;
import com.yekong.common.rxutils.BaseConsumer;
import com.yekong.mymvpdemo.home.constitute.DemoBarConstitute;

import io.reactivex.Observable;

/**
 * Created by xigua on 2017/10/16.
 */

public class DemoPresenter extends DemoBarConstitute.Presenter{
    @Override
    public void demo() {
        Log.e("DemoPresenter", "presenter");
        model.model().subscribe(new BaseConsumer(context, new BaseConsumer.OnResponseListenter() {
            @Override
            public void onSuccess(BaseEntity baseEntity) {
                action.action();
            }

            @Override
            public void onError(int errorCode, String message) {

            }
        }));
    }

    @Override
    public void getList() {
        Observable<String> data = model.getList();
        data.subscribe(s -> action.getList(s));
    }

    @Override
    public void getUserInfo() {
        model.getUserInfo().subscribe(new BaseConsumer(context, new BaseConsumer.OnResponseListenter() {
            @Override
            public void onSuccess(BaseEntity baseEntity) {
                action.getUserInfo("");
            }

            @Override
            public void onError(int errorCode, String message) {

            }
        }));
    }
}
