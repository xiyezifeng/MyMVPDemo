package com.yekong.common.viewutils;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

import me.iwf.photopicker.PhotoPicker;
import me.iwf.photopicker.PhotoPreview;

import static android.app.Activity.RESULT_OK;

/**
 * 负责选取多张、预览图片
 * Created by xigua on 2017/10/17.
 */

public class PhotoPickerUtil {
    public static void startChoose(Activity context , int max ,boolean enablePreview ,  ArrayList<String> selectedPhotos){
        PhotoPicker.builder()
                .setPhotoCount(max)
                .setShowCamera(true)
                .setShowGif(true)
                .setSelected(selectedPhotos)
                .setPreviewEnabled(enablePreview)
                .start(context, PhotoPicker.REQUEST_CODE);
    }
    public static void startPreview(Activity context , ArrayList<String> selectedPhotos , int position , boolean showDel ){
        PhotoPreview.builder()
                .setPhotos(selectedPhotos)
                .setCurrentItem(position)
                .setShowDeleteButton(showDel)
                .start(context);
    }

    public static ArrayList<String> parseData(int requestCode, int resultCode, Intent data){
        ArrayList<String> list = null;
        if (resultCode == RESULT_OK && requestCode == PhotoPicker.REQUEST_CODE) {
            if (data != null) {
                list = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
            }
        } else if (resultCode == RESULT_OK && requestCode == PhotoPreview.REQUEST_CODE) {
            if (data != null) {
                list = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
            }
        }
        return list;
    }
}
