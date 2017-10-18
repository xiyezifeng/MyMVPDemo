package com.yekong.common.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by xigua on 2017/10/18.
 */

public class RecyclerViewDriver extends RecyclerView.ItemDecoration {
    int top;
    int bottom;
    int left;
    int right;
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = left;
        outRect.right = right;
        outRect.bottom = bottom;
        outRect.top = top;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = 0;
        }
        if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount()-1) {
            outRect.bottom = 0;
        }
    }
    public RecyclerViewDriver(int top , int bottom , int left , int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }
}
