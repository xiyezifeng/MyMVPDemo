package com.yekong.mymvpdemo.home.constitute;


import com.yekong.common.base.BaseAction;
import com.yekong.common.base.BaseModel;
import com.yekong.common.base.BasePresenter;

import io.reactivex.Observable;

/**
 * Created by xigua on 2017/10/16.
 */

public interface DemoBarConstitute {
    interface View extends BaseAction {
        void action();
        void getList(String data);
        void getUserInfo(String info);
    }
    abstract class Model extends BaseModel {
        public abstract Observable<String> model();
        public abstract Observable<String> getList();
        public abstract Observable<String> getUserInfo();
    }
    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void demo();
        public abstract void getList();
        public abstract void getUserInfo();
    }
}
