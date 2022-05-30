package com.wxj.codebaselearn.pool.thread;

/**
 * @author wxj
 * @version 1.0.0
 * @ClassName SubThread2.java
 * @Description TODO
 * @createTime 2021年09月13日 21:34:00
 */
public class SubThread2 extends Thread {
    public SubThread2() {
        System.out.println("构造方法,Thread.currentThread().getName() : " +
                Thread.currentThread().getName());
        System.out.println("构造方法,this.getName() : " + this.getName());
    }
    @Override
    public void run() {
        System.out.println("run方法中,Thread.currentThread().getName():" +
                Thread.currentThread().getName());
        System.out.println("run 方法,this.getName() : " + this.getName());
    }}
//test
class Test02CurrentThread {
    public static void main(String[] args) throws InterruptedException {
        SubThread2 t2 = new SubThread2();
        t2.setName("t2");
        t2.start();
        Thread.sleep(500);
//main 线程睡眠 500 毫秒
//Thread(Runnable)构造方法形参是 Runnable 接口,调用时传递的实参是接口的实现类对象
        Thread t3 = new Thread(t2);
        t3.start();
    }
}