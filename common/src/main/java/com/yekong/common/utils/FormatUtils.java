package com.yekong.common.utils;

/**
 * Created by xigua on 2017/7/19.
 */

public class FormatUtils {
    /**
     * 转换至千为单位
     * @param number
     */
    public static String formatNumber2Thousand(String number){
        float a = Float.parseFloat(number);
        String b;
        if (a >= 1000 && a< 10000) {
            a = a / 1000;
            b = a + "千";
        }else if(a >= 10000){
            a = a / 1000;
            b = a + "万";
        }else{
            b = a + "";
        }
        return b;
    }
}
