package com.wxj.codebaselearn.ms;

import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 自定义线程池
 *
 * 为什么用自定义的线程池，不用jdk自带的线程池；
 * jdk 自带的线程池 的中阻塞队列用会出OOM问题
 *
 * newFixedThreadPool： LinkedBlockingQueue
 * newSingleThreadExecutor :LinkedBlockingQueue
 * newCachedThreadPool:SynchronousQueue
 * newScheduledThreadPool:DelayedWorkQueue
 *
 *
 * 线程的状态：新建，就绪、运行、阻塞、死亡
 * 线程池的状态：
 *
    RUNNABLE：运行状态，接受新任务，持续处理任务队列里的任务
    SHUTDOWN：不再接受新任务，但要处理任务队列里的任务
    STOP：不接受新任务，不再处理任务队列里的任务，中断正在进行中的任务
    TIDYING：表示线程池正在停止运作，中止所有任务，销毁所有工作线程
    TERMINATED：表示线程池已停止运作，所有工作线程已被销毁，所有任务已被清空或执行完毕
 *
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
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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
//        ExecutorService threadPool= Executors.newFixedThreadPool(5);
        /**
         * 一池一线程
         */
//        ExecutorService threadPool= Executors.newSingleThreadExecutor();
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
