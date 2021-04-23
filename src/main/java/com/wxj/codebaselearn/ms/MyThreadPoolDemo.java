package com.wxj.codebaselearn.ms;

import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 自定义线程池
 * @date 2021/4/23 0023 11:18
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque(3),
                Executors.defaultThreadFactory(),
        //默认抛出异常
        //new ThreadPoolExecutor.AbortPolicy()
        //回退调用者
        //new ThreadPoolExecutor.CallerRunsPolicy()
        //处理不来的不处理
        //new ThreadPoolExecutor.DiscardOldestPolicy()
                        new ThreadPoolExecutor.DiscardPolicy()
                );
        //模拟10个用户来办理业务 没有用户就是来自外部的请求线程.
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
//        threadPoolInit();
    }

    private static void threadPoolInit() {
        /**
         * 一池5个处理线程
         */
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);
        /**
         * 一池一线程
         */
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();
        /**
         * 一池N线程
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟10个用户来办理业务 没有用户就是来自外部的请求线程.
        try {
            for (int i = 1; i <= 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                try {
                    TimeUnit.MICROSECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
