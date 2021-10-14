package com.wxj.codebaselearn.pool.lock.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/13 0013 8:49
 */
@Slf4j
public class Demo3 {
    public static class T extends  Thread{
        // 休眠时间
        int sleepSeconds;
        CountDownLatch countDownLatch;
        public T(String name,int sleepSeconds,CountDownLatch countDownLatch){
            super(name);
            this.sleepSeconds = sleepSeconds;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run(){
            Thread ct = Thread.currentThread();
            long startTime = System.currentTimeMillis();
            log.info(startTime + "," + ct.getName() +",开始处理");
            try{
                TimeUnit.SECONDS.sleep(this.sleepSeconds);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
            long endTime = System.currentTimeMillis();
            log.info(endTime + "," + ct.getName() + ",处理完毕,耗时:" + (endTime - startTime));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "线程 start!");
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long starTime = System.currentTimeMillis();
        T t1 = new T("解析sheet1线程", 2, countDownLatch);
        t1.start();
        T t2 = new T("解析sheet2线程", 5, countDownLatch);
        t2.start();
        boolean result = countDownLatch.await(2, TimeUnit.SECONDS);
        System.out.println(System.currentTimeMillis() + "," + Thread.currentThread().getName() + "线程 end!");
        long endTime = System.currentTimeMillis();
        System.out.println("主线程耗时:" + (endTime - starTime) + ",result:" + result);
    }
}