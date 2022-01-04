package com.wxj.codebaselearn.pool.threadlocal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/31 0031 14:08
 */
public class Demo7 {

    public static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = new InheritableThreadLocal<>();
    static {
        DATE_FORMAT_THREAD_LOCAL.set(new SimpleDateFormat("yyyy-MM-dd"));
    }

}