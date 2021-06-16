package com.wxj.codebaselearn.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Java 多线程中两个线程交替执行，一个输出偶数，一个输出奇数
 */
public class ThreadPrint02 {
    static AtomicInteger casNum = new AtomicInteger(0);
    static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (; 100 > casNum.get();){
                if (!flag && (casNum.get() == 0 || casNum.incrementAndGet() % 2 == 0)){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(casNum.get());
                    flag = true;
                }
            }
        });

       Thread t2 =  new Thread(()->{
            for (; 100  >casNum.get() ;){
                if(flag && (casNum.incrementAndGet() % 2 == 1)){
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(casNum.get());
                    flag = false;
                }

            }
        });

        t1.start();
        t2.start();
    }
//public static void main(String[] args) {
//
//    Thread t1 = new Thread(() -> {
//        for (; 100 > casNum.get(); ) {
//            if (!flag && (casNum.get() == 0 || casNum.incrementAndGet() % 2 == 0)) {
//                try {
//                    Thread.sleep(100);// 防止打印速度过快导致混乱
//                } catch (InterruptedException e) {
//                    //NO
//                }
//
//                System.out.println(casNum.get());
//                flag = true;
//            }
//        }
//    }
//    );
//
//    Thread t2 = new Thread(() -> {
//        for (; 100 > casNum.get(); ) {
//            if (flag && (casNum.incrementAndGet() % 2 != 0)) {
//                try {
//                    Thread.sleep(100);// 防止打印速度过快导致混乱
//                } catch (InterruptedException e) {
//                    //NO
//                }
//
//                System.out.println(casNum.get());
//                flag = false;
//            }
//        }
//    }
//    );
//
//    t1.start();
//    t2.start();
//}
}
