package com.yekong.mymvpdemo.home.model;

import com.yekong.mymvpdemo.entity.StudentEntity;
import com.yekong.mymvpdemo.home.constitute.SdudentConsitute;

import java.util.ArrayList;

/**
 * Created by xigua on 2017/10/18.
 */

public class SdudentModel extends SdudentConsitute.Model {
    @Override
    public ArrayList<StudentEntity> getSdudentList() {
        ArrayList<StudentEntity> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new StudentEntity("小明",1,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=603621955,1179636658&fm=27&gp=0.jpg",1,null));
        }
        return list;
    }
}
