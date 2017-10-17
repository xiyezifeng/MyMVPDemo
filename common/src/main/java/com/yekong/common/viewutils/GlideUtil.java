package com.yekong.common.viewutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import static com.yekong.common.constant.Constant.comm_glide_error;
import static com.yekong.common.constant.Constant.comm_glide_holder;

/**
 * Created by xigua on 2017/10/17.
 */

public class GlideUtil {

    public static void loadImage(Context context, Object res, ImageView view){
        Glide.with(context)
                .load(res)
                .placeholder(comm_glide_holder)
                .error(comm_glide_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }

    public static void loadImageCenterCrop(Context context, Object res, ImageView view){
        Glide.with(context)
                .load(res)
                .centerCrop()
                .placeholder(comm_glide_holder)
                .error(comm_glide_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }

    public static void loadImageCenterCrop(Context context, Object res, ImageView view , int holder , int error){
        Glide.with(context)
                .load(res)
                .centerCrop()
                .placeholder(holder)
                .error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);
    }
    public static void loadCirImageCenterCrop(Context context, Object res, ImageView view){
        Glide.with(context)
                .load(res)
                .asBitmap()
                .centerCrop()
                .placeholder(comm_glide_holder)
                .error(comm_glide_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new BitmapImageViewTarget(view){
                    @Override
                    protected void setResource(Bitmap resource) {
                        view.setImageBitmap(resource);
                    }
                });
    }
    public static void loadCirImageCenterCrop(Context context, Object res, ImageView view , int holder , int error){
        Glide.with(context)
                .load(res)
                .asBitmap()
                .centerCrop()
                .placeholder(holder)
                .error(error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new BitmapImageViewTarget(view){
                    @Override
                    protected void setResource(Bitmap resource) {
                        view.setImageBitmap(resource);
                    }
                });
    }
}
