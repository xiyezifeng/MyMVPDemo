package com.yekong.common.rxutils;

import android.content.Context;
import android.util.Log;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yekong.common.dialog.BaseDialog;
import com.yekong.common.dialog.CustomAlertDialog;
import com.yekong.common.utils.DeviceUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xigua on 2017/10/17.
 */

public class RxUtils {


    public static <T> Observable<T> createObserver(Observable<T> observable , Context context , boolean showDialog , String dialogMessage){
        BaseDialog dialog = null;
        if (showDialog) {
            dialog = dialog(context,dialogMessage);
        }
        BaseDialog finalDialog = dialog;
        if (!DeviceUtil.checkNetAndShowToast(context)) {
            return Observable.just((T)"net")
                    .compose(((RxAppCompatActivity)context).bindToLifecycle())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }else
        return observable
                .compose(((RxAppCompatActivity)context).bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> {
                    return Observable.just((T)"error")
                            .compose(((RxAppCompatActivity)context).bindToLifecycle())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                })
                .doOnSubscribe(disposable -> {
                    if (showDialog)finalDialog.show();
                })
                .doOnError(throwable -> Log.e("observe", "error"))
                .doOnComplete(() -> {
                    if (showDialog) finalDialog.close();
                });
    }

    private static BaseDialog dialog(Context context , String message){
        if (message != null) {
            return new CustomAlertDialog(context, message);
        }else{
            return new CustomAlertDialog(context);
        }
    }

}
