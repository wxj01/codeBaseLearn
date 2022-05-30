package com.wxj.codebaselearn.pool.thread;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName MyThread.java
 * @Description TODO
 * @createTime 2021年09月13日 21:25:00
 */

//1)定义类继承 Thread
public class MyThread extends Thread{
    @Override //2) 重写 Thread 父类中的 run()
    public void run() { System.out.println("这是子线程打印的内容"); } }
//测试
class Test {
    public static void main(String[] args) {
        //3)创建子线程对象
        MyThread thread = new MyThread();
        //4)启动线程
        thread.start();
    } }
