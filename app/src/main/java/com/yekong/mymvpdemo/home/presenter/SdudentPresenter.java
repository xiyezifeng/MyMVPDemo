package com.yekong.mymvpdemo.home.presenter;

import com.yekong.mymvpdemo.home.constitute.SdudentConsitute;

/**
 * Created by xigua on 2017/10/18.
 */

public class SdudentPresenter extends SdudentConsitute.Presenter {
    @Override
    public void getSdudentList() {
        action.getSdudentList(model.getSdudentList());
    }
}
