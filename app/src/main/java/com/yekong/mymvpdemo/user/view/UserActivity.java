package com.yekong.mymvpdemo.user.view;

import android.widget.TextView;

import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.mymvpdemo.R;
import com.yekong.mymvpdemo.home.view.activity.DemoStatusActivity;
import com.yekong.mymvpdemo.user.constitute.UserConsitute;
import com.yekong.mymvpdemo.user.model.UserModel;
import com.yekong.mymvpdemo.user.presenter.UserPresenter;

/**
 * Created by xigua on 2017/10/17.
 */

public class UserActivity extends BaseToolbarActivity<UserPresenter,UserModel> implements UserConsitute.View {
    TextView text;
    @Override
    public void setPresenter() {
        presenter.setAction(this,model);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.user_activity_use;
    }

    @Override
    public void initData() {

    }


    @Override
    public void initView() {
        super.initView();
        text = getView(R.id.text);
        text.setOnClickListener(view -> startActivity(DemoStatusActivity.class));
    }


}
