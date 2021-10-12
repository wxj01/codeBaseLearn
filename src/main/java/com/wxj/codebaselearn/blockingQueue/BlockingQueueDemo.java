package com.wxj.codebaselearn.blockingQueue;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/12 0012 15:17
 */
public class BlockingQueueDemo<E> {

    int size; // 阻塞队列最大容量；
    ReentrantLock lock = new ReentrantLock();
    LinkedList<E> list = new LinkedList<E>(); //队列满时的等待条件
    Condition putCondition = lock.newCondition(); //队列满时的等待条件	
    Condition getCondition = lock.newCondition(); //队列空时的等待条件

    public BlockingQueueDemo(int size){
        this.size = size;
    }
    
    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == size){
                putCondition.await();
            }
            list.add(e);
            System.out.println("入队："+ e);
            getCondition.signal();
        }finally {
            lock.unlock();
        }
    }
    
    public E get() throws InterruptedException {
       E e;
       lock.lock();
       try{
           while (list.size() == 0){
               getCondition.await();
           }
           e = list.removeFirst();
           System.out.println("出队：" + e);
           putCondition.signal();
           return e;
       }finally {
           lock.unlock();
       }


    }

    public static void main(String[] args) {
        BlockingQueueDemo<Integer> queueDemo = new BlockingQueueDemo<>(2);

        for (int i = 0; i < 10; i++) {
            int data = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queueDemo.put(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            int data = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queueDemo.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    
}