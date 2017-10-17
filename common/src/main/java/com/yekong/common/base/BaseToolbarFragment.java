package com.yekong.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.yekong.common.R;

/**
 * Created by xigua on 2017/10/17.
 */

public abstract class BaseToolbarFragment<T extends BasePresenter, E extends BaseModel> extends BaseFragment<T, E> {

    public TextView title;
    public Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        initToolBarData();
    }
    public void initToolBarData() {
        title = getView(R.id.toolbar_title);
        toolbar = getView(R.id.toolbar);
        toolbar.setTitle("");
        title.setText(getBarTitle());
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if (isShowLeft()) {
            if (leftBtnResId() != 0) {
                toolbar.setNavigationIcon(leftBtnResId());
            } else {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (getMenu() != 0) {
            inflater.inflate(getMenu(), menu);
        }
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
    public String getBarTitle(){
        return "app";
    }
    public boolean isShowLeft(){return true;}
    public int leftBtnResId(){return 0;}
    public void onLeftClick(){}
    public int getMenu(){return 0;}
    public void onRightClick(int id){}
}
