/**
 * Yztz.com Inc.
 * Copyright (c) 2013-2015 All Rights Reserved.
 */
package com.example.wwmd.util;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Administrator
 * @version $Id: StrNullUtil.java, v 0.1 2015-6-16 上午9:07:39 Administrator Exp $
 */
public final class MyUtil {

    private MyUtil() {

    }


    // 判断对象非空
    public static boolean isNotNull(Object argObj) {
        return !MyUtil.isNull(argObj);
    }

    /**
     * 参数中是否有空值，若存在一个为空，则return true，全部不为空，则返回false
     * @param argObj
     * @return
     */
    public static boolean hasNull(Object... argObj) {
        for (Object o : argObj) {
            if (isNull(o)) {
                return true;
            }
        }
        return false;
    }

    // 判断对象为空
    @SuppressWarnings("rawtypes")
    public static boolean isNull(Object argObj) {
        if (argObj == null) {
            return true;
        }

        if (argObj instanceof String) {
            return ((String) argObj).trim().equals("") || ((String) argObj).trim().equals(" ") || ((String) argObj).trim().equals("null");
        }

        if (argObj instanceof Collection) {

            return ((Collection) argObj).isEmpty();
        }

        if (argObj instanceof Map) {

            return ((Map) argObj).isEmpty();
        }

        return false;
    }


    public static String format(Date datetime) {
        if (MyUtil.isNull(datetime))
            return null;

        try {
            SimpleDateFormat dateFromat = new SimpleDateFormat();
            dateFromat.applyPattern("yyyy-MM-dd HH:mm:ss");
            return dateFromat.format(datetime);
        } catch (Exception e) {
            return null;
        }
    }


}
