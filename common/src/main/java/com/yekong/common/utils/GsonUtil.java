package com.yekong.common.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

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

    public  <T> List<T> getList(String jsonString, Class<T> cls){
        List<T> list = new ArrayList<>();
        try {
            JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}