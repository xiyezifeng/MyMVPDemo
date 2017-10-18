package com.yekong.common.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtil {
    private static SharedUtil instance;
    private static SharedPreferences sharedPreferences;
    private Context app;
    private SharedUtil() {}

    public void init(Context app){
        if (sharedPreferences == null) {
            sharedPreferences = app.getSharedPreferences("app", Context.MODE_PRIVATE);
        }
    }

    public static SharedUtil getInstance() {
        if (instance == null) {
            instance = new SharedUtil();
        }
        return instance;
    }

    public void saveKey(String key , Object value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        }else if(value instanceof String){
            editor.putString(key, (String) value);
        }
        editor.commit();
    }

    public <T> T getValue(String key, Class<T> cls){
        if (cls == Integer.class) {
            return (T) Integer.valueOf(sharedPreferences.getInt(key, -1));
        }else if(cls == Boolean.class){
            return (T) Boolean.valueOf(sharedPreferences.getBoolean(key, false));
        }else if(cls == Long.class){
            return (T) Long.valueOf(sharedPreferences.getLong(key, -1));
        }else if(cls == Float.class){
            return (T) Float.valueOf(sharedPreferences.getFloat(key, -1f));
        }else if(cls == String.class){
            return (T) sharedPreferences.getString(key,"null");
        }
        return null;
    }
}