package com.wxj.jvm.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO  Java对象内存布局查看工具-JOL 查看对象头结构
 * @date 2022/2/15 0015 9:03
 */
public class TestObjectHeader {
    public static void main(String[] args) {
        Object o = new Object();
        String layout = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(layout);
    }
}