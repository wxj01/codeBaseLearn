package com.wxj.codebaselearn.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName testReenterLock.java
 * @Description TODO
 * @createTime 2022年04月05日 10:51:00
 */
public class testReenterLock {
    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        new Thread(()->{
            reentrantLock.lock();
            try{
               //逻辑代码
                TimeUnit.SECONDS.sleep(100);
                System.out.println("AAA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{
               //一定要执行的代码
                reentrantLock.unlock();
            }
        },"A").start();

        new Thread(()->{
            reentrantLock.lock();
            try{
                //逻辑代码
                System.out.println("BBB");
            } finally{
                //一定要执行的代码
                reentrantLock.unlock();
            }
        },"B").start();


        new Thread(()->{
            reentrantLock.lock();
            try{
                //逻辑代码
                System.out.println("CCC");
            } finally{
                //一定要执行的代码
                reentrantLock.unlock();
            }
        },"C").start();

    }
}
