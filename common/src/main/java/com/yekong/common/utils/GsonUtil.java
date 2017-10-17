package com.yekong.common.utils;

import com.google.gson.Gson;

public class GsonUtil {
    private static GsonUtil instance;
    private Gson gson;
    private GsonUtil() {
        gson = new Gson();
    }

    public static GsonUtil getInstance() {
        if (instance == null) {
            instance = new GsonUtil();
        }
        return instance;
    }
    public <T> T getModel (String json , Class<T> cls){
        return gson.fromJson(json, cls);
    }
}