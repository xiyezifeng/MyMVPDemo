package com.yekong.common.rxutils;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by xigua on 2017/10/17.
 */

public class RxBindUtils {
    /**
     * 点击时间间隔
     */
    public static final int TIME = 2;

    /**
     * 防抖处理
     * @param button
     * @param <T>
     * @return
     */
    public static <T> Observable<T> bindClick(View button){
        return (Observable<T>) RxView.clicks(button)
                .throttleFirst(TIME, TimeUnit.SECONDS);
    }

    /**
     * 绑定一个button
     * @param view
     * @return
     */
    public static InitialValueObservable<Boolean> bindCompound(Button view){
        return RxCompoundButton.checkedChanges((CompoundButton) view);
    }

}
