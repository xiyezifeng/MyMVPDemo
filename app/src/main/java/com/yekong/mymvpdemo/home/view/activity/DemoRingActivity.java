package com.yekong.mymvpdemo.home.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.common.storage.SharedUtil;
import com.yekong.common.utils.RingUtil;
import com.yekong.mymvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xigua on 2017/11/1.
 */

public class DemoRingActivity extends BaseToolbarActivity  {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.bar_toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_ring)
    Button btnRing;
    @BindView(R.id.btn_shake)
    Button btnShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_demo_ring;
    }

    @Override
    public void initData() {
        setBarColor(R.color.colorPrimary,128);
    }

    @OnClick({R.id.btn_ring, R.id.btn_shake})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_ring:
                if (SharedUtil.getInstance().getValue(RingUtil.RKEY,Boolean.class))
                RingUtil.getInstance().startRing(this);
                break;
            case R.id.btn_shake:
                if (SharedUtil.getInstance().getValue(RingUtil.SKEY,Boolean.class))
                RingUtil.getInstance().startShake(this);
                break;
        }
    }

}
