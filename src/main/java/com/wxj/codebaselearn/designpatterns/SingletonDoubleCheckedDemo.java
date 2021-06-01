package com.wxj.codebaselearn.designpatterns;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 双检锁
 * @date 2021/6/1 0001 14:59
 */
public class SingletonDoubleCheckedDemo {

    private volatile static SingletonDoubleCheckedDemo instance;

    private SingletonDoubleCheckedDemo() {
    }

    public static SingletonDoubleCheckedDemo getInstance(){
        // 第一次判空，可以减少加锁的次数，减少加锁的代价
        if(instance == null){
            synchronized (SingletonDoubleCheckedDemo.class){
                if(instance == null){
                    instance = new SingletonDoubleCheckedDemo();
                }
            }
        }
        return instance;
    }
}