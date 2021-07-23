package com.wxj.codebaselearn.pool.thread;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/23 0023 10:02
 */
public class RunnableThreadTest implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+"" + i);
            if(i == 20){
                RunnableThreadTest runner = new RunnableThreadTest();

                new Thread(runner,"新线程1").start();
                new Thread(runner,"新线程2").start();
            }
        }
    }
}