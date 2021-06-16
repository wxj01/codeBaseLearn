package com.wxj.codebaselearn.pool;

import java.util.concurrent.Semaphore;

/**
 * Java 多线程中两个线程交替执行，一个输出偶数，一个输出奇数
 */
public class ThreadPrint04 {
    static  int i = 1;

    public static void main(String[] args) {
        Semaphore oddSemphore = new Semaphore(1);
        Semaphore evenSemphore = new Semaphore(0);
        new Thread(new DigitPrinter(i,oddSemphore,evenSemphore)).start();
        new Thread(new DigitPrinter(i,evenSemphore,oddSemphore)).start();
    }

   static class DigitPrinter implements Runnable{

        static int num;
        Semaphore curSemaphore;
        Semaphore nextSemaphore;

        public DigitPrinter(int num,Semaphore curSemaphore,Semaphore nextSemaphore){
            this.num = num;
            this.curSemaphore = curSemaphore;
            this.nextSemaphore = nextSemaphore;
        }

        @Override
        public void run() {
            while (num <= 100){
                try{
                    curSemaphore.acquire();
                    System.out.println(num);
                    ++num;
                    nextSemaphore.release();
                }catch (Exception e){

                }
            }
        }
    }
}


