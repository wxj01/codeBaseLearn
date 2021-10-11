package com.wxj.codebaselearn.pool.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/11 0011 16:24
 */
@Slf4j
public class TestTryLock {
    private static ReentrantLock lock1 = new ReentrantLock(false);
    public static class T extends Thread{
        public T(String name){
            super(name);
        }

        @Override
        public void run(){
            try{
                log.info(System.currentTimeMillis() +":" + this.getName()+" 开始获取锁");
                // 获取锁超时时间设置为3秒，3秒内是否能获取锁都会返回
                if (lock1.tryLock()){
                    log.info(System.currentTimeMillis() +":" + this.getName()+" 获取到了锁");
                    // 获取锁之后，休眠5秒
                    TimeUnit.SECONDS.sleep(5);
                }else {
                    log.info(System.currentTimeMillis() +":" + this.getName()+" 没有获取到锁");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if(lock1.isHeldByCurrentThread())
                    lock1.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T t1 = new T("t1");
        T t2 = new T("t2");
        t1.start();
        t2.start();
    }
}