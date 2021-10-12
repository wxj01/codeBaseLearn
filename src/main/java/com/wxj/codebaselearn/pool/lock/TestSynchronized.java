package com.wxj.codebaselearn.pool.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/12 0012 12:56
 */
@Slf4j
public class TestSynchronized {
    static Object lock = new Object();

    public static class T1 extends Thread{
        @Override
        public void run(){
            log.info(System.currentTimeMillis() + "," + this.getName() +"准备获取锁!");
            synchronized (lock){
                log.info(System.currentTimeMillis() + "," + this.getName() +"获取锁成功!");
                try{
                    lock.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            log.info(System.currentTimeMillis() + "," + this.getName() +"释放锁成功!");
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run(){
            log.info(System.currentTimeMillis() + "," + this.getName() +"准备获取锁!");
            synchronized (lock){
                log.info(System.currentTimeMillis() + "," + this.getName() +"获取锁成功!");
                lock.notify();
                log.info(System.currentTimeMillis() + "," + this.getName() +"  notify!");
                try{
                    TimeUnit.SECONDS.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
                log.info(System.currentTimeMillis() + "," + this.getName() +"准备释放锁!");

            }
            log.info(System.currentTimeMillis() + "," + this.getName() +"准备释成功!");
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