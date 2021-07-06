package com.wxj.codebaselearn.designpatterns.singleton;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO  懒汉模式，等到用的时候才实例化
 * @date 2021/6/1 0001 13:57
 */
public class SingletonLazyDemo {

    private static  SingletonLazyDemo instance;
    private SingletonLazyDemo(){};

    public static SingletonLazyDemo getInstance(){
        if(instance == null){
            instance = new SingletonLazyDemo();
        }
        return instance;
    }
}