package com.wxj.codebaselearn.pool.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/14 0014 16:24
 */
@Slf4j
public class Demo1 {
    //访问次数
    static int count = 0;

    //模拟访问一次
    public static void request() throws InterruptedException {
        // 访问耗时 1秒
        TimeUnit.SECONDS.sleep(1);
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        long starTime  = System.currentTimeMillis();
        int threadSize = 100;

        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++){
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        long endTime = System.currentTimeMillis();
        log.info(Thread.currentThread().getName() +",耗时 "+(endTime - starTime) + ",count = " + count);
    }
}