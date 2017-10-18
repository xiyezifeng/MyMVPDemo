package com.yekong.mymvpdemo.home.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.yekong.common.base.BaseToolbarActivity;
import com.yekong.common.baseadapter.ItemClickListener;
import com.yekong.common.viewutils.TKLayoutUtil;
import com.yekong.common.widget.RecyclerViewDriver;
import com.yekong.mymvpdemo.R;
import com.yekong.mymvpdemo.entity.StudentEntity;
import com.yekong.mymvpdemo.home.adapter.SdudentAdapter;
import com.yekong.mymvpdemo.home.constitute.SdudentConsitute;
import com.yekong.mymvpdemo.home.model.SdudentModel;
import com.yekong.mymvpdemo.home.presenter.SdudentPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xigua on 2017/10/18.
 */

public class StudentActivity extends BaseToolbarActivity<SdudentPresenter,SdudentModel> implements SdudentConsitute.View, ItemClickListener {
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tk_layout)
    TwinklingRefreshLayout tkLayout;

    private SdudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void setPresenter() {
        presenter.setAction(this,model);
    }

    @Override
    public int getViewLayoutId() {
        return R.layout.activity_student;
    }

    @Override
    public void initData() {
       presenter.getSdudentList();
    }

    @Override
    public void initView() {
        super.initView();
        TKLayoutUtil.initRecylerViewLinear(recyclerView,this);
        TKLayoutUtil.initTwRefreshLayout(tkLayout,this);
        recyclerView.addItemDecoration(new RecyclerViewDriver(1,1,0,0));
        adapter = new SdudentAdapter(this,this,null);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getSdudentList(ArrayList<StudentEntity> list) {
        adapter.setList(list);
    }

    @Override
    public void onViewClick(int id, int position, Object model) {

    }

    @Override
    public void onItemClick(View view, int position, Object model) {

    }
}
