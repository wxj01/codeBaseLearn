package com.wxj.codebaselearn.ms;

/**
 * 1. wait 和 notify 需要在 synchronized 代码块中运行，否则 java.lang.IllegalMonitorStateException
 * 2. notify 不能在 wait 之前执行，否则 线程一直卡在wait ，无法执行后续代码
 *
 */
public class WaitNotifyDemo {

    static Object objectLock  = new Object();


    public static void main(String[] args) {

        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() +"\t" +"-----come in");

                try{
                    objectLock.wait();
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +"\t" +"-----被唤醒");
            }
        },"A").start();

        new Thread(()->{
            synchronized (objectLock){
                try{
                    objectLock.notify();
                }catch (Exception e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +"\t" +"-----通知");
            }
        },"B").start();
    }
}
