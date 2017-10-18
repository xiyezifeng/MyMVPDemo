package com.yekong.mymvpdemo.home.view.activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.common.eventbus.EventBusManager;
import com.yekong.mymvpdemo.R;
import com.yekong.mymvpdemo.home.constitute.DemoBarConstitute;
import com.yekong.mymvpdemo.home.model.DemoModel;
import com.yekong.mymvpdemo.home.presenter.DemoPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static com.yekong.common.eventbus.EventBusManager.EVENT_1;
import static com.yekong.common.eventbus.EventBusManager.EVENT_2;

/**
 * Created by xigua on 2017/10/16.
 */

public class DemoBarActivity extends BaseToolbarActivity<DemoPresenter, DemoModel> implements DemoBarConstitute.View {

    TextView text;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusManager.unregister(this);
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
        presenter.getList();
//        presenter.demo();
//        presenter.getUserInfo();

    }

    @Override
    public void initView() {
        super.initView();
        text = getView(R.id.text);
        text.setText("demo activity");
        text.setOnClickListener(view -> startActivity(DemoPhotoChooseActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBusManager.register(this);
    }
}
