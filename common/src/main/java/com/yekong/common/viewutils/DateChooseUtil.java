package com.yekong.common.viewutils;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.yekong.common.R;
import com.yekong.common.utils.DateUtil;

import java.util.Date;

/**
 * 时间选择器
 * Created by xigua on 2017/11/1.
 */

public class DateChooseUtil {

    public static void showTimeChoose(Context context,OnChooseComplete chooseComplete){
        int[] data = new int[3];
        View view = View.inflate(context, R.layout.comm_view_time,null);
        TimePicker picker = view.findViewById(R.id.timepicker);
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(view)
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    data[0] = picker.getCurrentHour();
                    data[1] = picker.getCurrentMinute();
                    data[2] = 0;
                    chooseComplete.complete(data);
                    dialogInterface.dismiss();
                })
                .setNegativeButton("取消",null)
                .create();
        dialog.show();
    }

    public static void showDateChoose(Context context,OnChooseComplete chooseComplete){
        int[] data = new int[3];
        View view = View.inflate(context, R.layout.comm_view_date,null);
        DatePicker picker = view.findViewById(R.id.datepicker);
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(view)
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    data[0] = picker.getYear();
                    data[1] = picker.getMonth()+1;
                    data[2] = picker.getDayOfMonth();
                    chooseComplete.complete(data);
                    dialogInterface.dismiss();
                })
                .setNegativeButton("取消",null)
                .create();
        dialog.show();
    }

    public static void showDateTimeChoose(Context context,OnChooseComplete chooseComplete){
        int[] data = new int[6];
        View view = View.inflate(context, R.layout.comm_view_date,null);
        DatePicker picker = view.findViewById(R.id.datepicker);
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(view)
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    data[0] = picker.getYear();
                    data[1] = picker.getMonth()+1;
                    data[2] = picker.getDayOfMonth();
                    dialogInterface.dismiss();
                })
                .setNegativeButton("取消",null)
                .create();
        dialog.show();
        dialog.setOnDismissListener(dialogInterface -> {
            View view_time = View.inflate(context, R.layout.comm_view_time,null);
            TimePicker picker_time = view_time.findViewById(R.id.timepicker);
            AlertDialog dialog_time = new AlertDialog.Builder(context)
                    .setView(view_time)
                    .setPositiveButton("确定", (dialogInterface1, i) -> {
                        data[3] = picker_time.getCurrentHour();
                        data[4] = picker_time.getCurrentMinute();
                        data[5] = 0;
                        chooseComplete.complete(data);
                        dialogInterface1.dismiss();
                    })
                    .setNegativeButton("取消",null)
                    .create();
            dialog_time.show();
        });
    }

    public static void showDateChoose(Context context,String startDate , String endDate ,OnChooseComplete chooseComplete){
        int[] data = new int[3];
        View view = View.inflate(context, R.layout.comm_view_date,null);
        DatePicker picker = view.findViewById(R.id.datepicker);
        Date start = DateUtil.StringToDate(startDate);
        Date end = DateUtil.StringToDate(endDate);
        picker.init(start.getYear(),start.getMonth(),start.getDay(),null);
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setView(view)
                .setPositiveButton("确定", (dialogInterface, i) -> {
                    data[0] = picker.getYear();
                    data[1] = picker.getMonth()+1;
                    data[2] = picker.getDayOfMonth();
                    chooseComplete.complete(data);
                    dialogInterface.dismiss();
                })
                .setNegativeButton("取消",null)
                .create();
        dialog.show();
    }

    public interface OnChooseComplete{
        void complete(int[] data);
    }
}

