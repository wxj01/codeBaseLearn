package com.wxj.codebaselearn.pool;

import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/14 0014 13:25
 */
public class SynchronizedTest {

    private static final Object lock = new Object();



    public static void testWait() throws InterruptedException {
        synchronized (lock) {
//            System.out.println("进入synchronized代码中");

            // 阻塞住，被唤醒之前不会输出aa，也就是还没离开synchronized
            lock.wait();
            System.out.println("aa");
        }
    }

    public static void testNotify() throws InterruptedException {
        synchronized (lock) {
            lock.notify();
            System.out.println("bb");
        }
    }


    public static void main(String[] args) {



        new Thread(()->{
            try {
                testWait();
//                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"1").start();



        new Thread(()->{
            try {
                testWait();
                TimeUnit.SECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"2").start();


//        new Thread(()->{
//            try {
//                testNotify();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"3").start();
//
//
//        new Thread(()->{
//            try {
//                testNotify();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },"4").start();
    }
}