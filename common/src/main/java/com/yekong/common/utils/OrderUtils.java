package com.yekong.common.utils;

import java.util.List;

/**
 * 排序
 * Created by xigua on 2017/7/21.
 */

public class OrderUtils {
    /**
     * 倒序排列
     * @param t
     * @param <T>
     * @return
     */
    public static  <T> List<T> orderList (List<T> t){
        boolean even ;
        if (t.size() % 2 == 0) {
            //偶数
            even = true;
        }else{
            //奇数
            even = false;
        }

        int center = t.size()/2;
        if (even) {
            center = center - 1;
        }else{
        }
        T temp;
        for (int i = 0; i < t.size(); i++) {
            //置换
            if (i == center) {
                //中心点
                if (even) {
                    temp = t.get(i);
                    t.set(i, t.get(i + 1));
                    t.set(i + 1, temp);
                }else{

                }
                break;
            }else{
                temp = t.get(i);
                t.set(i, t.get(t.size() - 1 - i));
                t.set(t.size() - 1 - i , temp);
            }
        }
        return t;
    }
}
