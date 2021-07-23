package com.wxj.codebaselearn.pool.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/23 0023 10:05
 */
public class CallableThreadTest implements Callable<Integer> {


    public static void main(String[] args) {

        CallableThreadTest callableThreadTest = new CallableThreadTest();

        FutureTask futureTask = new FutureTask<>(callableThreadTest);

        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() + " 的循环变量i 的值" + i);
            if(i == 20){
                new Thread(futureTask,"有返回值的线程").start();
            }
        }


        try{
            System.out.println(" 子线程的返回值 "+futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public Integer call() throws Exception {

        int i = 0;
        for (;i < 100; i++){
            System.out.println(Thread.currentThread().getName() + "" + i);
        }
        return i;
    }


}