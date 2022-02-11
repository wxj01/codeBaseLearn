package com.wxj.codebaselearn.pool.thread;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 一个异常被抛出后，如果没有被捕获处理，则会一直向上抛。异常一旦被Thread.run() 抛出后，就不能在程序中对异常进行捕获，最终只能由JVM捕获
 * @date 2022/2/11 0011 15:02
 */
public class TestThreadException {

    public static void main(String[] args) {

        try {
            new Thread(()->{
                int i = 1/0;
            },"ABC").start();
        }catch (Exception e){
            System.out.println("捕获线程抛出的异常");
            e.printStackTrace();
        }

    }
}