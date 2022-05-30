package com.wxj.codebaselearn.cache;

import lombok.ToString;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName TestCacheLine.java
 * @Description TODO 缓存一致性协议，测试缓存行，cpu读取缓存行 64 bytes
 *
 * 1、注释 20行和22号代码，耗时：4521
 * 2、放开 20行和22号代码，耗时
 * @createTime 2022年02月19日 19:00:00
 */
public class TestCacheLine {

    public static  long count = 10_0000_0000L;

    public static class T{
        private long d1,d2,d3,d4,d5,d6,d7;
//        private long  d1,d2,d3,d4,d5;
        public long a = 0;
        private long d9,d10,d11,d12,d13,d14,d15;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                arr[0].a = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                arr[1].a = i;
            }
            latch.countDown();
        });

        long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
//        long end = System.nanoTime();

        System.out.println("耗时："+ (System.nanoTime() - start) / 100_0000);

    }

    @Test
    public void test1(){

    }





}
