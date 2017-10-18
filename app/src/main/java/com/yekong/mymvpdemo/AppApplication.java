package com.yekong.mymvpdemo;

import com.yekong.common.baseapp.BaseApplication;

import static com.yekong.common.constant.Constant.CRASH;

/**
 * Created by xigua on 2017/10/17.
 */

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        if (CRASH)
        reagisterCrash(getPackageName());
    }
}
