package com.yekong.common.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.yekong.common.eventbus.EventBusManager;
import com.yekong.common.utils.LogUtils;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xigua on 2017/10/16.
 */

public  abstract  class BaseActivity<T extends BasePresenter , E extends BaseModel>  extends RxAppCompatActivity {
    public T presenter;
    public E model;

    protected final int TYPE_NOMAL = -1;
    protected int TYPE = TYPE_NOMAL;//-1 未刷新 0刷新 1更多

    protected final int TYPE_REFRUSH = 0;
    protected final int TYPE_MORE = 1;

    protected Context context;
    Unbinder unbinder;
    protected View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getT(this, 0);
        model = getT(this, 1);
        context = this;
        if (presenter != null) {
            presenter.context = context;
        }
        if (model != null) {
            model.context = context;
        }
        setPresenter();
        if (getViewLayoutId()>0) {
            rootView = LayoutInflater.from(this).inflate(getViewLayoutId(), null);
            setContentView(rootView);
            unbinder = ButterKnife.bind(this,rootView);
            initView();
            initData();
        }
        if (enableEventBus()) {
            EventBusManager.register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (enableEventBus()) {
            EventBusManager.unregister(this);
        }
    }

    public <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (
                    o.getClass()
                    .getGenericSuperclass()
            )).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassCastException e) {
        }
        return null;
    }

    public Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void log(String log){
        LogUtils.showLogE("applog",log);
    }

    public <V> V getView(int id){
        return (V) findViewById(id);
    }

    public boolean enableEventBus(){return false;}

    public void setBarColor(int color , int alpha){
        StatusBarUtil.setColor(this, getResources().getColor(color),alpha);
    }
    protected void startActivity(Class object){
        startActivity(new Intent(context,object));
    }
    protected void startActivity(Class object , Bundle bundle){startActivity(new Intent(context,object),bundle);}
    protected void startActivity(Class object , int code){startActivityForResult(new Intent(context,object),code);}

    public abstract void setPresenter();
    public abstract int getViewLayoutId();
    public abstract void initData();
    public abstract void initView();

    protected <T> T getIntentValue(String key){
        //getExtras.key 是否等于 getExtrasString 有待效验
        return (T) getIntent().getExtras().get(key);
}
}
