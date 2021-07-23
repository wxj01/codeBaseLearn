package com.wxj.codebaselearn.pool.thread;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/23 0023 9:52
 */
public class FirstThreadTest extends Thread{
    int i = 0;
    // 重写run 方法，run 方法的方法就是现场执行体
    public void run(){
        for (;i < 100; i++){
            System.out.println(getName()+"" +i);
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100;i++){
            System.out.println(Thread.currentThread().getName());

            if(i == 20){
                new FirstThreadTest().start();
                new FirstThreadTest().start();
            }
        }

    }
}