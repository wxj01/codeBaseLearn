package com.wxj.codebaselearn.pool.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/14 0014 14:29
 */
@Slf4j
public class Demo2 {
    public static void main(String[] args) {
        log.info(String.valueOf(System.currentTimeMillis()));

        // 任务计数器
        AtomicInteger atomicInteger = new AtomicInteger(1);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(()->{
            int i = atomicInteger.getAndIncrement();
            log.info(Thread.currentThread().getName());
            log.info(System.currentTimeMillis() + "第"+ i + "次" + "开始执行");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info(System.currentTimeMillis() + "第" + i + "次" + "执行结束");
        },1,1, TimeUnit.SECONDS);
    }
}