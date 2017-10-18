package com.yekong.common.baseapp;

import android.app.Application;
import android.support.multidex.MultiDex;

import com.yekong.common.storage.SharedUtil;

import me.drakeet.library.CrashWoodpecker;
import me.drakeet.library.PatchMode;

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
        SharedUtil.getInstance().init(instance);
    }

    public void reagisterCrash(String name){
        CrashWoodpecker.instance()
                .withKeys("widget", name)
                .setPatchMode(PatchMode.SHOW_LOG_PAGE)
                .setPatchDialogUrlToOpen("https://drakeet.me")
                .setPassToOriginalDefaultHandler(true)
                .flyTo(this);
    }
    public static Application getInstance() {
        return instance;
    }
}
