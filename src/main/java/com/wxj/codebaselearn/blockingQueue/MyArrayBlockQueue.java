package com.wxj.codebaselearn.blockingQueue;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/6/28 0028 14:56
 */
public class MyArrayBlockQueue {

    AtomicInteger count = new AtomicInteger(0);



    private int head;
    private int tail;

    private String[] arr;

    public MyArrayBlockQueue(int arrLen) {
        this.count = count;
        this.head = head;
        this.tail = tail;
        this.arr = new String[arrLen];
    }

    public synchronized void put(String data){
        while (count.get() >= arr.length){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        arr[tail] = data;
        this.tail = (tail+1)% arr.length; // 这一步是什么意思
        count.getAndIncrement();
        notify();
    }

    public synchronized String take(){
        while (count.get() <= 0){
            try{
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        String str = arr[head];
        this.head = (head+1)%arr.length; // 这一步是什么意思
        count.getAndIncrement();
        notify();
        return str;

    }

    public synchronized int size(){
        return arr.length;
    }
}