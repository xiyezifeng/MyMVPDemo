package com.yekong.common.base;

import android.content.Context;

/**
 * Created by xigua on 2017/10/16.
 */

public abstract class BasePresenter<T extends BaseAction,M extends BaseModel>{
    public M model;
    public T action;
    public Context context;
    public void setAction(T a,M m){
        this.action = a;
        this.model = m;
    }

}
