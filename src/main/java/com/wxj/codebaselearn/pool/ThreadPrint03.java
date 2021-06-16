package com.wxj.codebaselearn.pool;
/**
 * Java 多线程中两个线程交替执行，一个输出偶数，一个输出奇数
 */
public class ThreadPrint03 {
    static volatile int num = 0;
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (; num < 100;){
                if (!flag && (num ==0 || ++num % 2 == 0)){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }

                    System.out.println(num);
                    flag = true;
                }
            }
        });

        Thread t2 = new Thread(()->{
            for (;num < 100;){
                if(flag && ++num % 2 == 1){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }

                    System.out.println(num);
                    flag = false;
                }
            }
        });

        t1.start();
        t2.start();
    }
}
