package com.wxj.codebaselearn.jvm2cpu;

import java.util.Random;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 模拟把堆 打满 直接OOM
 * @date 2021/4/23 0023 16:05
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "wxj";
        while (true){
            str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
            str.intern();
        }
    }

/*
    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    at java.util.Arrays.copyOf(Arrays.java:3332)
    at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
    at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
    at java.lang.StringBuilder.append(StringBuilder.java:208)
    at com.wxj.codebaselearn.ms.JavaHeapSpaceDemo.main(JavaHeapSpaceDemo.java:15)*/

}