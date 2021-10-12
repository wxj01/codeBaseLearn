package com.wxj.codebaselearn.pool.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/12 0012 14:39
 */
@Slf4j
public class TestCondition02 {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static class T1 extends Thread{
        @Override
        public void run(){
            lock.lock();
            try {
                condition.await();
            }catch (Exception e){
                log.info("中断标志：" + this.isInterrupted());
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();

        TimeUnit.SECONDS.sleep(2);
        //给t1线程发送中断信号
        System.out.println("1、t1中断标志：" + t1.isInterrupted());
        t1.interrupt();
        System.out.println("2、t1中断标志：" + t1.isInterrupted());

    }
}