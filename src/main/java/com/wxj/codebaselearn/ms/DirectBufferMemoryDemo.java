package com.wxj.codebaselearn.ms;

import java.nio.ByteBuffer;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO  Direct buffer memory
 *
 * 配置参数：-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 * @date 2021/4/25 0025 10:07
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        // 参数配置maxDirectMemory 5MB
        System.out.println("配置的maxDirectMemory : "+ (sun.misc.VM.maxDirectMemory()/(double)(1024*1024)) +"MB");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // -XX:MaxDirectMemorySize=5m 我们配置为5MB,但是实际使用6MB,让报错看看
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
        System.out.println(byteBuffer);
    }
}
//
//结果：
//        Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory