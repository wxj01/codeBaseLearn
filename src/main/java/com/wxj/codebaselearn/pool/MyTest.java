package com.wxj.codebaselearn.pool;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/5/13 0013 9:58
 */
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyTest {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 5, 5, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3));
        // 向线程池提交任务
//        for (int i = 0; i < threadPool.getCorePoolSize(); i++) {
        for (int i = 1; i < 11; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int x = 0; x < 2; x++) {
                        System.out.println(Thread.currentThread().getName() + ":" + x);
                        try {
//                            Thread.sleep(2000);
                            Thread.sleep(Integer.MAX_VALUE);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        // 关闭线程池
        threadPool.shutdown(); // 设置线程池的状态为SHUTDOWN，然后中断所有没有正在执行任务的线程
        // threadPool.shutdownNow(); // 设置线程池的状态为STOP，然后尝试停止所有的正在执行或暂停任务的线程，并返回等待执行任务的列表，该方法要慎用，容易造成不可控的后果
    }
}
