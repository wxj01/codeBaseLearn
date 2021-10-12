package com.wxj.codebaselearn.pool.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/12 0012 14:10
 */
@Slf4j
public class TestCondition {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static class T1 extends Thread{
        @Override
        public void run(){
            log.info(System.currentTimeMillis() + "," + this.getName() + "准备获取锁!");
            lock.lock();
            try {
                log.info(System.currentTimeMillis() + "," + this.getName() + "获取锁成功!");
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            log.info(System.currentTimeMillis() + "," + this.getName() + "释放锁成功!");
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run(){
            log.info(System.currentTimeMillis() + "," + this.getName() + "准备获取锁!");
            lock.lock();
            try {
                log.info(System.currentTimeMillis() + "," + this.getName() + "获取锁成功!");
                condition.signal();
                log.info(System.currentTimeMillis() + "," + this.getName() + " signal!");
                try {
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
                log.info(System.currentTimeMillis() + "," + this.getName() + "准备释放锁!");
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            log.info(System.currentTimeMillis() + "," + this.getName() + "释放锁成功!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.setName("t1");
        t1.start();

        TimeUnit.SECONDS.sleep(5);

        T2 t2 = new T2();
        t2.setName("t2");
        t2.start();
    }
}