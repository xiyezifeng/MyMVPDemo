package com.yekong.common.rxutils;

import android.content.Context;

import com.yekong.common.baseentity.BaseEntity;
import com.yekong.common.utils.GsonUtil;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by xigua on 2017/7/27.
 */

public class BaseConsumer implements Consumer<String> {
    private OnResponseListenter listenter;
    private Context context;

    public BaseConsumer(Context context , OnResponseListenter listenter) {
        this.listenter = listenter;
        this.context = context;
    }

    @Override
    public void accept(@NonNull String responseBody) throws Exception {
        String body = responseBody;
        if (body.equals("net")){
            listenter.onError(-2,"net error");
        }else if (body.equals("error")) {
            listenter.onError(-1,"error");
        }else{
//            BaseEntity entity = JSON.parseObject(body, BaseEntity.class);
            BaseEntity entity = GsonUtil.getInstance().getModel(body, BaseEntity.class);
            if (null != entity)
                listenter.onSuccess(entity);
            else
                listenter.onError(-1,"error");
        }
    }
    public interface OnResponseListenter{
        void onSuccess(BaseEntity baseEntity);
        void onError(int errorCode, String message);
    }
}
