package com.yekong.common.utils;

import android.content.Context;
import android.util.Log;

/**
 * Created by xigua on 2017/7/11.
 */

public class LogUtils {

    private static boolean debug = true;
    private static LogUtils instance ;
    private Context appContext;
    private static final String TAG = "toast";

    public static LogUtils getInstance () {
        if (null == instance) {
            synchronized (LogUtils.class) {
                if (null == instance) {
                    instance = new LogUtils();
                }
            }
        }
        return instance;
    }

    public static void showLogE(String tag, String content){
        if (debug) {
            try {
                Log.e(tag, content);
            } catch (Exception e) {
                Log.d(TAG,"log 出错  :  "+e.getMessage());
            }
        }
    }
    public static void showLogd(String tag, String content){
        if (debug) {
            try {
                Log.d(tag, content);
            } catch (Exception e) {
                Log.d(TAG,"log 出错  :  "+e.getMessage());
            }
        }
    }
}
