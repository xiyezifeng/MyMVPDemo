package com.yekong.common.viewutils;

import android.content.Context;
import android.graphics.Color;

import com.bigkoo.pickerview.OptionsPickerView;
import com.yekong.common.R;

import java.util.List;

/**
 * Created by xigua on 2018/1/2.
 */

public class PickerViewUtil {
    public static void showPicker(Context context ,
                            List list1,
                            List list2 ,
                            List list3 ,
                            int level,
                            OptionsPickerView.OnOptionsSelectListener listener) {
        OptionsPickerView builder = new OptionsPickerView.Builder(context, listener)
                .setTitleText("")
                .setContentTextSize(16)//设置滚轮文字大小
                .setDividerColor(Color.LTGRAY)//设置分割线的颜色
                .setSelectOptions(0, 0 )//默认选中项
                .setBgColor(Color.WHITE)
                .setTitleBgColor(Color.WHITE)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.GRAY)
                .setSubmitColor(context.getResources().getColor(R.color.colorPrimary))
                .setTextColorCenter(Color.BLACK)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabels("", "", "")
                .setBackgroundId(0x66000000) //设置外部遮罩颜色
                .setCyclic(false, false, false)
                .build();
        switch (level) {
            case 1:
                builder.setPicker(list1);
                break;
            case 2:
                builder.setPicker(list1, list2);
                break;
            case 3:
                builder.setPicker(list1, list2, list3);
                break;
        }
        builder.show();
    }
}
