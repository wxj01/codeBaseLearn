package com.wxj.codebaselearn.pool.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/14 0014 14:01
 */
@Slf4j
public class Demo1 {
    public static void main(String[] args) {
      log.info(String.valueOf(System.currentTimeMillis()));
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.schedule(() ->{
            log.info(System.currentTimeMillis() + "开始执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info(System.currentTimeMillis() + "执行结束");

        },2,TimeUnit.SECONDS);
    }
}