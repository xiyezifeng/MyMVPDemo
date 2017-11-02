package com.yekong.common.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.yekong.common.constant.Constant;

/**
 * Created by xigua on 2017/7/11.
 */

public class ToastUtils {
    private static boolean debug = Constant.APP_DEBUG;
    private static ToastUtils instance ;
    private Context appContext;
    private static final String TAG = "toast";


    public static ToastUtils getInstance () {
        if (null == instance) {
            synchronized (ToastUtils.class) {
                if (null == instance) {
                    instance = new ToastUtils();
                }
            }
        }
        return instance;
    }

    public static void showToast(Context context, String content){
        if (debug) {
            try {
                Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Log.d(TAG,"toast 出错  :  "+e.getMessage());
            }
        }
    }
}
