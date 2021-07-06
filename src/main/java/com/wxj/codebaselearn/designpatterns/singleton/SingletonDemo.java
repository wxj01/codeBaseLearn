package com.wxj.codebaselearn.designpatterns.singleton;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/6/1 0001 13:41
 */
public class SingletonDemo {

    // 创建一个SingleDemo 对象
    private static SingletonDemo instance = new SingletonDemo();

    // 添加私有的构造方法，这样该类不会被实例化
    private SingletonDemo(){}

    // 获取唯一对象的
    public static SingletonDemo getInstance(){
        return  instance;
    }
}