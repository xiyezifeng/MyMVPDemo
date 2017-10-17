package com.yekong.mymvpdemo.home.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.common.viewutils.TKLayoutUtil;
import com.yekong.common.widget.MyStatusFramlayout;
import com.yekong.mymvpdemo.R;

/**
 * Created by xigua on 2017/10/17.
 */

public class DemoStatusActivity extends BaseToolbarActivity {
    MyStatusFramlayout statusFramlayout;
    RelativeLayout content;
    TwinklingRefreshLayout refreshLayout;
    RecyclerView recyclerView;

    @Override
    public void setPresenter() {

    }

    @Override
    public int getViewLayoutId() {
        return com.yekong.common.R.layout.comm_demo_status_layout;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        super.initView();
        statusFramlayout = (MyStatusFramlayout) getView(R.id.status_layout);
        content = (RelativeLayout) getView(R.id.content_layout);
        refreshLayout = (TwinklingRefreshLayout) getView(R.id.tk_layout);
        recyclerView = (RecyclerView) getView(R.id.recycler_view);
        statusFramlayout.setListener(new MyStatusFramlayout.PageStatusListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoadSuccess() {
                content.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadFail() {

            }

            @Override
            public boolean onErrorClick() {
                statusFramlayout.childLoadSuccess();
                return false;
            }
        });
        statusFramlayout.childLoadFail();
        TKLayoutUtil.initTwRefreshLayout(refreshLayout,context);
        TKLayoutUtil.initRecylerViewLinear(recyclerView,context);
    }
}
