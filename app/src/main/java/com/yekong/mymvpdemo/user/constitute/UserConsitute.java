package com.yekong.mymvpdemo.user.constitute;

import com.yekong.common.base.BaseAction;
import com.yekong.common.base.BaseModel;
import com.yekong.common.base.BasePresenter;

import java.util.ArrayList;

/**
 * Created by xigua on 2017/10/17.
 */

public interface UserConsitute {
    interface View extends BaseAction{
        void upload(boolean status);
    }
    abstract class Model extends BaseModel{
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void upload(ArrayList<String > files);
    }
}
