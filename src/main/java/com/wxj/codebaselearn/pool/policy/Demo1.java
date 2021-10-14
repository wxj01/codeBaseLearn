package com.wxj.codebaselearn.pool.policy;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/13 0013 14:31
 */
@Slf4j
public class Demo1 {
    static class Task implements Runnable{
        String name ;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            log.info(Thread.currentThread().getName() + "处理 "+ this.name);
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
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

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                (r, executors) -> {
                    // 自定义饱和策略
                    // 记录一下无法处理的任务
                    log.info("无法处理的任务" + r.toString());
                });

        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Task("任务-"+i));
        }
        threadPoolExecutor.shutdown();
    }
}