package com.wxj.codebaselearn.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/7 0007 13:19
 */
@Slf4j
public class TestCountDownLatch {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,
                20,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(Integer.MAX_VALUE),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.execute(()->{
                    for(int i = 0; i <3; i++){

            CountDownLatch countDownLatch = new CountDownLatch(99);
            for (int j = 1; j <= 99;j++){
                countDownLatch.countDown();
                log.info("输出countDown 的值："+countDownLatch.getCount());
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            try {
                countDownLatch.await();
                log.info("开始countDownLatch");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        });


//        for(int i = 0; i <1; i++){
//            log.info("开始countDownLatch");
//            CountDownLatch countDownLatch = new CountDownLatch(99);
//            for (int j = 0; j < 100;j++){
//                int finalJ = j;
//                threadPoolExecutor.execute(()->{
//
////                    log.info("输出j 的值："+ finalJ);
//                    countDownLatch.countDown();
//                    log.info("输出countDown 的值："+countDownLatch.getCount());
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                });
//            }
//            try {
//                countDownLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }
    }



}