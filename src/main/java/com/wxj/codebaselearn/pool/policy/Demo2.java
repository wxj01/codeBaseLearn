package com.wxj.codebaselearn.pool.policy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/14 0014 13:26
 */
@Slf4j
public class Demo2 {
    static class Task implements  Runnable{
        String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            log.info(Thread.currentThread().getName() + "处理"+this.name);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                10,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(),
                (r, executors) -> {
                    // 自定义饱和策略
                    // 记录一下无法处理的task
                    log.info("无法处理的task :" + r.toString());
                }) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
//                super.beforeExecute(t, r);
                log.info(System.currentTimeMillis() + "," + t.getName() + ",开始执行任务" + r.toString());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
//                super.afterExecute(r, t);
                log.info(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ", 任务" + r.toString());
            }

            @Override
            protected void terminated() {
//                super.terminated();
                log.info(System.currentTimeMillis() + "," + Thread.currentThread().getName() + ",关闭线程池");
            }
        };

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Task("任务t-"+i) );
        }
        TimeUnit.SECONDS.sleep(1);
        threadPoolExecutor.shutdown();
    }
}