package com.wxj.codebaselearn.ms;

import java.lang.ref.WeakReference;

/**
 * @author wxj
 * @version 1.0
 * @description: 弱引用
 *
 * 只要垃圾回收，不管JVM的内存空间是否足够，都会回收对象占用的内存
 * @date 2021/4/23 0023 15:16
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);

        System.out.println(o);
        System.out.println(weakReference.get());

        o = null;
        System.gc();

        System.out.println("==================================");

        System.out.println(o);
        System.out.println(weakReference.get());


        /*结果：
        java.lang.Object@78308db1
        java.lang.Object@78308db1
        ==================================
        null
        null*/
    }
}