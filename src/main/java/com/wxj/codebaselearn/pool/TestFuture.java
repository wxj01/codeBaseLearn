package com.wxj.codebaselearn.pool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/29 0029 10:29
 */
public class TestFuture {

//    int corePoolSize,
//    int maximumPoolSize,
//    long keepAliveTime,
//    TimeUnit unit,
//    BlockingQueue<Runnable> workQueue,
//    ThreadFactory threadFactory,
//    RejectedExecutionHandler handler
//
    public static final ExecutorService service = new ThreadPoolExecutor(
            3,
            3,
            20,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        // 任务1
        Future<Boolean> booleanTask = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(10000);
                return true;
            }
        });

        // 任务2
        Future<String> stringTask = service.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "Hello World";
            }
        });

        // 任务3
        Future<Integer> integerTask = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return new Random().nextInt(100);
            }
        });

        while (true) {
            if (booleanTask.isDone() && !booleanTask.isCancelled()) {
                Boolean result = booleanTask.get();
                System.err.println("任务1-10s： " + result);
                break;
            }
        }

        while (true) {
            if (stringTask.isDone() && !stringTask.isCancelled()) {
                String result = stringTask.get();
                System.err.println("任务2-3s： " + result);
                break;
            }
        }

        while (true) {
            if (integerTask.isDone() && !integerTask.isCancelled()) {
                Integer result = integerTask.get();
                System.err.println("任务3-2s：" + result);
                break;
            }
        }

        // 执行时间
        System.err.println("time: " + (System.currentTimeMillis() - start)/1000 +"s");

    }

}