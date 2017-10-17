package com.yekong.common.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
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
            setContentView(getViewLayoutId());
            initView();
            initData();
        }
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
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

    protected void startActivity(Class object){
        startActivity(new Intent(context,object));
    }

    public abstract void setPresenter();
    public abstract int getViewLayoutId();
    public abstract void initData();
    public abstract void initView();
}
