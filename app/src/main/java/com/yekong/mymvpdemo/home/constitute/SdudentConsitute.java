package com.yekong.mymvpdemo.home.constitute;

import com.yekong.common.base.BaseAction;
import com.yekong.common.base.BaseModel;
import com.yekong.common.base.BasePresenter;
import com.yekong.mymvpdemo.entity.StudentEntity;

import java.util.ArrayList;

/**
 * Created by xigua on 2017/10/18.
 */

public interface SdudentConsitute {
    interface View extends BaseAction{
        void getSdudentList(ArrayList<StudentEntity> list);
    }

    abstract class Model extends BaseModel{
        public abstract ArrayList<StudentEntity> getSdudentList();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getSdudentList();
    }
}
