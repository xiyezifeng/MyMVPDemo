package com.yekong.mymvpdemo.user.presenter;

import com.yekong.common.baseapi.BaseApi;
import com.yekong.common.baseentity.BaseEntity;
import com.yekong.common.rxutils.BaseConsumer;
import com.yekong.common.rxutils.RxUtils;
import com.yekong.mymvpdemo.api.Api;
import com.yekong.mymvpdemo.user.constitute.UserConsitute;

import java.util.ArrayList;

/**
 * Created by xigua on 2017/10/17.
 */

public class UserPresenter extends UserConsitute.Presenter {

    @Override
    public void upload(ArrayList<String> files) {
        BaseApi.getInstance().uploadFile(files, body ->{
                    if (null!=body)
                    RxUtils.createObserver(Api.homeApi().upload("value",body),context,true,null)
                            .subscribe(new BaseConsumer(context, new BaseConsumer.OnResponseListenter() {
                                @Override
                                public void onSuccess(BaseEntity baseEntity) {
                                    action.upload(true);
                                }

                                @Override
                                public void onError(int errorCode, String message) {
                                    action.upload(false);
                                }
                            }));
                    else
                        action.upload(false);
                }
        );
    }
}
