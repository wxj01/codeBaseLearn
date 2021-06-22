package com.wxj.codebaselearn.ms;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

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
        WeakReference<Object> weakReference2 = new WeakReference<>("OK");

        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(weakReference2.get());

//        o = null;
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(30);
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("==================================");

        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println(weakReference2.get());





        /*结果：
        java.lang.Object@78308db1
        java.lang.Object@78308db1
        ==================================
        null
        null*/
    }
}