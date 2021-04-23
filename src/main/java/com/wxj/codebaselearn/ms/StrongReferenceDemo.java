package com.wxj.codebaselearn.ms;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 强引用
 *
 * JVM 开始垃圾回收，对于强引用对象，就算出现类OOM 也不回收
 * 即使该对象以后永远都不会用到，JVM也不会回收
 *
 * @date 2021/4/23 0023 15:01
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object(); // 这样定义就是强引用
        Object o2 = o1; // o2 引用赋值
        o1 = null; //置空
        System.gc();
        System.out.println(o2);
    }
}