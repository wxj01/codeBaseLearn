package com.wxj.codebaselearn.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 测试多次调用 Executors.newCachedThreadPool()
 * @date 2021/9/30 0030 15:45
 */
public class TestNewCachedThreadPool {

    public static void main(String[] args) {

        for (int a = 0; a < 3; a++) {
            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            System.out.println("cachedThreadPool- "+a +":"+cachedThreadPool.hashCode());
//            for (int i = 0; i < 10; i++) {
//                final int index = i;
//                try {
////                    Thread.sleep(index * 1000);
//                    System.out.println("a:"+a +",i:"+i);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                cachedThreadPool.execute(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        System.out.println(index);
//                    }
//                });
//            }
        }
    }
}