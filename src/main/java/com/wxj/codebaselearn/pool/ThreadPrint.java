package com.wxj.codebaselearn.pool;

/**
 * Java 多线程中两个线程交替执行，一个输出偶数，一个输出奇数
 */
public class ThreadPrint {

    public static void main(String[] args) {

        final ThreadPrint threadPrint = new ThreadPrint();

        Thread t1 = new Thread(threadPrint::print1);
        Thread t2 = new Thread(threadPrint::print2);

        t1.start();
        t2.start();
    }

    public synchronized void print2(){
        for (int i = 1;i <= 100;i+=2){
            System.out.println(i);

            this.notify();
            try{
                this.wait();
                Thread.sleep(100); // 防止打印速度过快导致混乱
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void print1(){
        for (int i = 0;i <= 100; i+= 2){
            System.out.println(i);
            this.notify();
            try{
                this.wait();
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
