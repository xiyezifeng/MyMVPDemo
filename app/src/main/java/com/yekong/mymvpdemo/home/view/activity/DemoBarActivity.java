package com.yekong.mymvpdemo.home.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.common.storage.SharedUtil;
import com.yekong.common.utils.RingUtil;
import com.yekong.common.viewutils.DateChooseUtil;
import com.yekong.mymvpdemo.R;
import com.yekong.mymvpdemo.home.constitute.DemoBarConstitute;
import com.yekong.mymvpdemo.home.model.DemoModel;
import com.yekong.mymvpdemo.home.presenter.DemoPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.yekong.common.eventbus.EventBusManager.EVENT_1;
import static com.yekong.common.eventbus.EventBusManager.EVENT_2;

/**
 * Created by xigua on 2017/10/16.
 */

public class DemoBarActivity extends BaseToolbarActivity<DemoPresenter, DemoModel> implements DemoBarConstitute.View {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.tv_date)
    TextView tvDate;


    @Override
    public boolean enableEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Integer event) {
        switch (event) {
            case EVENT_1:
                break;
            case EVENT_2:
                break;
        }
    }

    @Override
    public void setPresenter() {
        presenter.setAction(this, model);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void action() {
    }

    @Override
    public boolean isShowLeft() {
        return false;
    }

    @Override
    public void getList(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getUserInfo(String info) {

    }

    @Override
    public String getBarTitle() {
        return "demo";
    }

    @Override
    public void initData() {
//        presenter.getList();
//        presenter.demo();
//        presenter.getUserInfo();
        SharedUtil.getInstance().saveKey(RingUtil.RKEY, !SharedUtil.getInstance().getValue(RingUtil.RKEY, Boolean.class));
        SharedUtil.getInstance().saveKey(RingUtil.SKEY, !SharedUtil.getInstance().getValue(RingUtil.SKEY, Boolean.class));
    }

    @Override
    public void initView() {
        super.initView();
        text.setText("demo activity");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text, R.id.tv_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text:
                startActivity(DemoRingActivity.class);
                break;
            case R.id.tv_date:
                DateChooseUtil.showDateTimeChoose(this, data -> {
                    Log.d("DemoBarActivity", "data:" + data);
                    Toast.makeText(context,""+data[0] +data[1]+data[2]+"   "+data[3]+data[4]+data[5],Toast.LENGTH_SHORT).show();
                });
                break;
        }
    }
}
