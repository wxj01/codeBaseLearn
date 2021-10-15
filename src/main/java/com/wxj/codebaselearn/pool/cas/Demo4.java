package com.wxj.codebaselearn.pool.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/15 0015 10:15
 */
public class Demo4 {
    // 访问此时
    static AtomicInteger count = new AtomicInteger();

    //模拟访问一次
    public static void request(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //对count + 1
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int threadSize = 100;

        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            new Thread(()->{
                try {
                    for (int j = 0; j < 10; j++) {
                        request();
                    }
                }finally {
                    countDownLatch.countDown();
                }

            }).start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "，耗时：" + (endTime - startTime) + ",count=" + count);    }
}