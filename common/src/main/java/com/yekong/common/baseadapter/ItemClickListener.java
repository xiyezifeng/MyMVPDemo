package com.yekong.common.baseadapter;

import android.view.View;

/**
 * Created by xigua on 2017/10/17.
 */

public interface ItemClickListener<M> {
    //子view点击
    void onViewClick(int id, int position, M model);
    //布局view点击
    void onRootViewClick(View view, int position, M model);
}
