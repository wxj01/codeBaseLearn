package com.wxj.codebaselearn.ms;

import java.lang.ref.SoftReference;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 软引用
 *
 * 当系统内存充足时   不会 被回收
 * 当系统内存不足时    会  被回收
 *
 * @date 2021/4/23 0023 15:08
 */
public class SoftRefMemoryEnough {
    public static void main(String[] args) {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());


        /* 结果
        java.lang.Object@78308db1
        java.lang.Object@78308db1
        null
        java.lang.Object@78308db1*/
    }
}