package com.yekong.common.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xigua on 2017/10/16.
 */

public abstract class BaseFragment<T extends BasePresenter , E extends BaseModel> extends RxFragment {
    public T presenter;
    public E model;
    public View rootView;

    Unbinder unbinder;

    protected final int TYPE_NOMAL = -1;
    protected int TYPE = TYPE_NOMAL;//-1 未刷新 0刷新 1更多
    protected final int TYPE_REFRUSH = 0;
    protected final int TYPE_MORE = 1;


    protected boolean isInit = false;
    protected boolean isInitData = false;
    protected boolean viewInit = false;
    protected Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getT(this, 0);
        model = getT(this, 1);
        setPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getViewLayoutId(),null);
        unbinder = ButterKnife.bind(this, rootView);
        setHasOptionsMenu(true);
        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (null == this.context)
            this.context = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rootView = view;
        isInit = true;
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }
    /**
     * 是否可以加载数据
     * 可以加载数据的条件：
     * 1.视图已经初始化
     * 2.视图对用户可见
     */
    public void isCanLoadData() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint()){
            if (!viewInit) {
                viewInit = true;
                initView();
            }
            if (!isInitData) {
                isInitData = true;
                initData();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isCanLoadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    protected  <T> T getT(Object o, int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassCastException e) {
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected  <V> V getView(int id){
        return (V) getView().
                findViewById(id);
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
}
