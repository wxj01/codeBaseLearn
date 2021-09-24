package com.wxj.codebaselearn.ms;

import java.util.concurrent.*;

/**
 * @author wxj
 * @version 1.0
 * @description: CountDownLatch 案例
 *
 * CountDownLatch :让一些线程阻塞直到另外一些完成后才被唤醒。
 * CountDownLatch主要有两个方法,当一个或多个线程调用await方法时,调用线程会被阻塞.
 * 其他线程调用countDown方法计数器减1(调用countDown方法时线程不会阻塞),
 * 当计数器的值变为0,因调用await方法被阻塞的线程会被唤醒,继续执行
 *
 * @date 2021/4/23 0023 9:09
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20,
                20,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(Integer.MAX_VALUE),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        threadPoolExecutor.execute(()->{
            try {
                closeDoor1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        closeDoor1();
//        closeDoor();
    }

    /**
     * 关门案例
     *
     * @throws InterruptedException
     */
    private static void closeDoor1() throws InterruptedException {

        for (int j = 0; j< 3 ; j++){
            CountDownLatch countDownLatch = new CountDownLatch(6);
            for (int i = 1; i <= 6; i++) {
                new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "上完自习");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }, String.valueOf(i)).start();
            }

            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t班长锁门离开教室");
        }





//        new Thread(()->{}).join(1000);
//        LockSupport.park();
//        LockSupport.parkUntil(100);
//        LockSupport.parkNanos(100);
    }


    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "上完自习");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t班长锁门离开教室");
    }

}