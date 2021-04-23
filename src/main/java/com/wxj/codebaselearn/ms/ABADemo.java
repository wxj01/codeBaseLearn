package com.wxj.codebaselearn.ms;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 模拟ABA 问题
 * @date 2021/4/22 0022 19:44
 */
public class ABADemo {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);

        },"t1").start();


        new Thread(()->{
            try {
                // 先暂停1秒，保证t1 线程能完成ABA
                TimeUnit.SECONDS.sleep(1);
                System.out.println(atomicReference.compareAndSet(100,2021) +"\t"+atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

    }
}