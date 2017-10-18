package com.yekong.mymvpdemo.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yekong.common.baseadapter.BaseAdapter;
import com.yekong.common.baseadapter.ItemClickListener;
import com.yekong.common.viewutils.GlideUtil;
import com.yekong.mymvpdemo.R;
import com.yekong.mymvpdemo.entity.StudentEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by xigua on 2017/10/18.
 */

public class SdudentAdapter extends BaseAdapter<StudentEntity> {

    public SdudentAdapter(ItemClickListener listener, Context context, List<StudentEntity> list) {
        super(listener, context, list);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(Context context, ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.item_student, null));
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder h, int position, StudentEntity studentEntity) {
        ViewHolder holder = (ViewHolder) h;
        GlideUtil.loadCirImageCenterCrop(context,studentEntity.getsAvatar(),holder.civAvatar);
        holder.tvName.setText(studentEntity.getsName());
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.civ_avatar)
        CircleImageView civAvatar;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
