package com.chutang.pay.utils;

/**
 * @email 17673178733@163.com
 * @author:YanCan
 * @date: 2019/5/11
 * @time: 12:36
 */
public class StringUtils {

    public static boolean isEmpty(String... obj) {
        if (obj == null) {
            return true;
        } else {
            String[] var4 = obj;
            int var3 = obj.length;

            for(int var2 = 0; var2 < var3; ++var2) {
                String string = var4[var2];
                if (string == null || string.equals("")) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isNoEmpty(String... obj) {
        return !isEmpty(obj);
    }
}
