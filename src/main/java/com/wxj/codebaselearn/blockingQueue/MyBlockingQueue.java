package com.wxj.codebaselearn.blockingQueue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  面试中第二次被问到
 *
 *  手写一个阻塞队列
 */
public class MyBlockingQueue<T> {

    AtomicInteger count = new AtomicInteger(0);
    private LinkedList<T> linkedList = new LinkedList<>();

    private  Object lock  = new Object();

    int maxSize ;
    int minSize = 0;

    public MyBlockingQueue(int maxSize){
        this.maxSize = maxSize;
    }

    public int getSize(){
        return count.get();
    }


    public void put(T t){
        synchronized (lock){
            while (count.get() == maxSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            linkedList.add(t);
            count.getAndDecrement();
            lock.notify();
        }
    }

    public T take(){
        T temp;
        synchronized (lock){
            while (count.get() == minSize){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            temp = linkedList.removeFirst();
            count.decrementAndGet();
            lock.notify();
        }
        return temp;
    }


    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<String>(5);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");
        queue.put("e");

        new Thread(new Runnable() {
            @Override
            public void run() {
                queue.put("+1");
                queue.put("+2");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                queue.take();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                queue.take();
            }
        }).start();

    }
}
