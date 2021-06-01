package com.wxj.codebaselearn.designpatterns;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 懒汉式，线程安全  synchronized 线程安全，范围大 效率低
 * @date 2021/6/1 0001 14:00
 */
public class SingletonLazySafeDemo {

    private static SingletonLazySafeDemo instance;

    private SingletonLazySafeDemo() {
    };

    public static synchronized   SingletonLazySafeDemo getInstance(){
        if(instance == null){
            instance = new SingletonLazySafeDemo();
        }
        return instance;
    }
}