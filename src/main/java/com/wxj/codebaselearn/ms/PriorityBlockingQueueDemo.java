package com.wxj.codebaselearn.ms;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/4/26 0026 16:12
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {

        PriorityBlockingQueue<Object> priorityBlockingQueue = new PriorityBlockingQueue<>();

        System.out.println("priorityBlockingQueue 的默认大小："+priorityBlockingQueue.size());

        for (int i = 0; i < 100;i++){
            System.out.println("第几个"+i);
            priorityBlockingQueue.add("a"+i);
            System.out.println("priorityBlockingQueue 的大小："+priorityBlockingQueue.size());
        }
    }
}