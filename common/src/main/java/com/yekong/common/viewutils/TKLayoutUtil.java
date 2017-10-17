package com.yekong.common.viewutils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lcodecore.tkrefreshlayout.Footer.LoadingView;
import com.lcodecore.tkrefreshlayout.IBottomView;
import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;

/**
 * Created by xigua on 2017/10/17.
 */

public class TKLayoutUtil {
    public static void initRecylerViewLinear(RecyclerView recyclerView , Context context){
        initRecylerViewLinear(recyclerView,context, LinearLayoutManager.VERTICAL);
    }

    public static void initRecylerViewLinear(RecyclerView recyclerView , Context context , int orientation){
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(orientation);
        manager.setSmoothScrollbarEnabled(false);
        manager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
    }

    public static void initRecylerViewGrid(RecyclerView recyclerView , Context context , int count){
        GridLayoutManager manager = new GridLayoutManager(context,count);
        manager.setSmoothScrollbarEnabled(false);
        manager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
    }

    public static void initTwRefreshLayout(TwinklingRefreshLayout refreshlayout , Context context){
        initTwRefreshLayout(refreshlayout,context , new SinaRefreshView(context) , new LoadingView(context));
    }

    public static void initTwRefreshLayout(TwinklingRefreshLayout refreshlayout , Context context ,IHeaderView headerView){
        initTwRefreshLayout(refreshlayout,context , headerView , new LoadingView(context));
    }

    public static void initTwRefreshLayout(TwinklingRefreshLayout refreshlayout , Context context ,IBottomView bottomView){
        initTwRefreshLayout(refreshlayout,context , new SinaRefreshView(context) , bottomView);
    }

    public static void initTwRefreshLayout(TwinklingRefreshLayout refreshlayout , Context context ,IHeaderView headerView , IBottomView bottomView){
        refreshlayout.setHeaderView(headerView);
        refreshlayout.setBottomView(bottomView);
    }
}
