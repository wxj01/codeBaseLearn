package com.wxj.codebaselearn.designpatterns;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO  饿汉式
 * @date 2021/6/1 0001 14:03
 */
public class SingletonHungryDemo {

    // 饿汉模式下，会先将对象初始化
    private static SingletonHungryDemo instance = new SingletonHungryDemo();

    private SingletonHungryDemo() {
    }

    public static SingletonHungryDemo getInstance(){
        return instance;
    }
}