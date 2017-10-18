package com.yekong.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.yekong.common.R;

import butterknife.ButterKnife;

/**
 * Created by xigua on 2017/10/16.
 */

public abstract class BaseToolbarActivity<T extends BasePresenter, E extends BaseModel>  extends BaseActivity <T ,E>{

    public TextView title;
    public Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {
        initToolBarData();
    }
    public void initToolBarData() {
        toolbar = getView(R.id.toolbar);
        title = getView(R.id.toolbar_title);
        toolbar.setTitle("");
        String t = getBarTitle();
        title.setText(t);
        setSupportActionBar(toolbar);
        if (isShowLeft()) {
            if (leftBtnResId() != 0) {
                toolbar.setNavigationIcon(leftBtnResId());
            } else {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            toolbar.setNavigationOnClickListener(view -> onLeftClick());
        }
        Toolbar.OnMenuItemClickListener itemClickListener = item -> {
            onRightClick(item.getItemId());
            onOptionsItemSelected(item);
            return true;
        };
        toolbar.setOnMenuItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenu() != 0) {
            getMenuInflater().inflate(getMenu(), menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
    public String getBarTitle(){
        return "app";
    }
    public boolean isShowLeft(){return true;}
    public int leftBtnResId(){return 0;}
    public void onLeftClick(){finish();}
    public int getMenu(){return 0;}
    public void onRightClick(int id){}
}
