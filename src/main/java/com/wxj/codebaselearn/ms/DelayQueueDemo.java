package com.wxj.codebaselearn.ms;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/4/26 0026 16:43
 */
public class DelayQueueDemo {
    public static void main(String[] args) {

        // 默认是一个 initially empty
        DelayQueue<Delayed> delayeds = new DelayQueue<>();

        System.out.println("delayeds 的默认大小："+delayeds.size());

        Delayed delayed = new Delayed() {
            @Override
            public int compareTo(Delayed o) {
                return 0;
            }

            @Override
            public long getDelay(TimeUnit unit) {
                return 0;
            }
        };

        for (int i = 0; i < 100;i++){
            System.out.println("第几个"+i);
            delayeds.add(delayed);
            System.out.println("priorityBlockingQueue 的大小："+delayeds.size());
        }
    }
}