package com.yekong.common.baseapp;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.yekong.common.storage.SharedUtil;

import me.drakeet.library.CrashWoodpecker;
import me.drakeet.library.PatchMode;

import static com.yekong.common.constant.Constant.CRASH;

/**
 * Created by xigua on 2017/10/17.
 */

public class BaseApplication extends Application{
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MultiDex.install(this);
        if (CRASH)
        CrashWoodpecker.instance()
                .withKeys("widget", getApplicationInfo().packageName)
                .setPatchMode(PatchMode.SHOW_LOG_PAGE)
                .setPatchDialogUrlToOpen("https://drakeet.me")
                .setPassToOriginalDefaultHandler(true)
                .flyTo(this);
        SharedUtil.getInstance().init(instance);
    }

    public static Application getInstance() {
        return instance;
    }
}
