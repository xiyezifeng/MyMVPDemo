package com.yekong.mymvpdemo.home.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.common.viewutils.ImagePickerUtil;
import com.yekong.common.viewutils.PhotoPickerUtil;
import com.yekong.mymvpdemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xigua on 2017/10/18.
 */

public class DemoPhotoChooseActivity extends BaseToolbarActivity {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

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
        return R.layout.activity_demo_photo_choose;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        super.initView();
    }


    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                ImagePickerUtil.openSinglePhoto(true);
                ImagePickerUtil.chooseImage(this);
                break;
            case R.id.button2:
                PhotoPickerUtil.startChoose(this,9,true,null);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePickerUtil.REQUEST_CODE_SELECT) {
            ArrayList list = ImagePickerUtil.parseImage(requestCode, resultCode, data , this);
            Toast.makeText(this, "list.size():" + (list==null?"null":list.size()), Toast.LENGTH_SHORT).show();
        }else{
            ArrayList list = PhotoPickerUtil.parseData(requestCode, resultCode, data);
            Toast.makeText(this, "list.size():" + (list==null?"null":list.size()), Toast.LENGTH_SHORT).show();
        }
    }
}
