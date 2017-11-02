package com.yekong.common.utils;

import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xigua on 2017/10/26.
 */

public class BundleUtil {
    private Bundle bundle;
    private Map<String,Object> values = new HashMap<>();
    private static BundleUtil util;
    private BundleUtil(){}

    public static BundleUtil create(){
        util = new BundleUtil();
        return util;
    }
    public BundleUtil putValue(String key , Object value){
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (value instanceof String) {
            bundle.putString(key, (String) value);
        }
        else if(value instanceof Boolean){
            bundle.putBoolean(key, (Boolean) value);
        }
        else if(value instanceof Float){
            bundle.putFloat(key, (Float) value);
        }
        else if(value instanceof Integer){
            bundle.putInt(key,  ((Integer) value).intValue());
        }
        else if(value instanceof Serializable){
            bundle.putSerializable(key, (Serializable) value);
        }
        else if(value instanceof Parcelable){
            bundle.putParcelable(key, (Parcelable) value);
        }
        return util;
    }
    public Bundle build(){
        return bundle;
    }

    public static  <T> T getValue(Bundle bundle , String key){
        return (T) bundle.get(key);
    }
}
