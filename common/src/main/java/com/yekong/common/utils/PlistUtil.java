package com.yekong.common.utils;

import android.content.Context;

import com.dd.plist.NSArray;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.PropertyListParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by xigua on 2018/1/5.
 */

public class PlistUtil {
    private static List<String> sheng = new ArrayList<>();
    private static List<List<String>> shi = new ArrayList<>();
    private static List<List<List<String>>> qu = new ArrayList<>();
    private static boolean isInitData = false;

    public static boolean isInitData() {
        return isInitData;
    }

    public static List<String> getSheng() {
        return sheng;
    }

    public static List<List<String>> getShi() {
        return shi;
    }

    public static List<List<List<String>>> getQu() {
        return qu;
    }

    public static void prasePlist(Context context){
        new Thread(() -> {
            NSDictionary dicroot = null;
            try {
                dicroot =  (NSDictionary)PropertyListParser.parse(context.getAssets().open("area.plist"));                // 基于SAX的实现
                //parser.parse(context.getAssets().open("area.plist"));        // area.plist是你要解析的文件，该文件需放在assets文件夹下
                dicroot.toString();
                Set<String> sets = dicroot.keySet();
                for (String set : sets) {
                    NSDictionary ary = (NSDictionary) dicroot.get(set);
                    Set<String> arySets = ary.keySet();
                    for (String arySet : arySets) {
                        sheng.add(arySet);//省份
                        NSDictionary arry_1 = (NSDictionary) ary.get(arySet);
                        Set<String> shiKeySets = arry_1.keySet();
                        List<String> shiList = new ArrayList<>();
                        List<List<String>> quList = new ArrayList<>();
                        for (String shiKeySet : shiKeySets) {
                            //0 第二级key
                            NSDictionary quDic = (NSDictionary) arry_1.get(shiKeySet);
                            Set<String> shiSets = quDic.keySet();
                            for (String shiSet : shiSets) {
                                //市
                                shiList.add(shiSet);
                                NSArray quAry = (NSArray) quDic.get(shiSet);
                                List<String> quTemp = new ArrayList<>();
                                int count = quAry.count();
                                for (int i = 0; i < count; i++) {
                                    NSObject object = quAry.objectAtIndex(i);
                                    String quStr = object.toJavaObject().toString();
//                                        Log.d("PlistUtil", quStr);
                                    quTemp.add(quStr);
                                }
                                quList.add(quTemp);
                            }
                        }
                        qu.add(quList);
                        shi.add(shiList);
                    }
                }
//                    Log.d("PlistUtil", "sheng:" + sheng);
//                    Log.d("PlistUtil", "shi:" + shi);
//                    Log.d("PlistUtil", "qu:" + qu);
//                    Log.d("PlistUtil", "a");
                isInitData = true;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
