package com.yekong.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean ValueNONull(String value) {
        if (value != null && !value.equals("") && !value.equals("null")) {
            return true;
        }
        return false;
    }

    /***
     * 手机号码正则匹配
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        //^((13[0-9])|(15[^4,\D])|(18[0,5-9]))\d{8}$
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");

        Matcher m = p.matcher(mobiles);

        System.out.println(m.matches()+"---");

        return m.matches();

        }

    /**
     * 找出指定字符串在目标字符串中的位置
     * 
     * @param source
     *            目标字符串
     * @param pattern
     *            指定字符串
     * @return 指定字符串在目标字符串中的位置
     */
    public static int match(String source, String pattern) {
        int index = -1;
        boolean match = true;

        for (int i = 0, len = source.length() - pattern.length(); i <= len; i++) {
            match = true;

            for (int j = 0; j < pattern.length(); j++) {
                if (source.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * @说明 String 待检验字符串 Int 检验动作 1:邮箱 2:手机 3:密码(8-20位 含字母数字) 4:金额 5:座机 6:身份证号
     * @return boolean
     */
    public static boolean strFormat(String str, int action) {
        boolean tag = true;
        String pattern1 = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        String pattern2 = "^[1][3,4,5,7,8][0-9]{9}$";
        String pattern3 = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$";
        String pattern4 = "^([0-9]+(.[0-9]{1,2})?)|(-[0-9]+(.[0-9]{1,2})?)$";
        String pattern5 = "1([\\d]{10})|((\\+[0-9]{2,4})?\\(?[0-9]+\\)?-?)?[0-9]{7,8}";
//		String pattern6 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
        String pattern6 = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Pattern pattern;
        if (action == 1) {
            pattern = Pattern.compile(pattern1);
        } else if (action == 2) {
            pattern = Pattern.compile(pattern2);
        } else if (action == 3) {
            pattern = Pattern.compile(pattern3);
        } else if (action == 4) {
            pattern = Pattern.compile(pattern4);
        } else if (action == 5) {
            pattern = Pattern.compile(pattern5);
        } else {
            pattern = Pattern.compile(pattern6);
        }
        Matcher mat = pattern.matcher(str);
        if (!mat.matches()) {
            tag = false;
        }
        return tag;
    }
}
