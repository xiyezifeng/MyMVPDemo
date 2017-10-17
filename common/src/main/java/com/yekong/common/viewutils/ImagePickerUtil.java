package com.yekong.common.viewutils;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.view.CropImageView;
import com.yekong.common.baseapp.BaseApplication;
import com.yekong.common.utils.DensityUtil;

/**
 * 负责选取单张，裁剪
 * Created by xigua on 2017/10/17.
 */

public class ImagePickerUtil {
   /* public static void openMutilPhoto (int maxNumber){
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setMultiMode(true);
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(false);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(maxNumber);    //选中数量限制
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }*/

    public static void openSinglePhoto(boolean isCrop){
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setMultiMode(false);
        imagePicker.setImageLoader(new GlideImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(isCrop);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setSelectLimit(1);    //选中数量限制
        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
        imagePicker.setFocusWidth(DensityUtil.dip2px(BaseApplication.getInstance(),220));   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(DensityUtil.dip2px(BaseApplication.getInstance(),220));  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
    }

}
