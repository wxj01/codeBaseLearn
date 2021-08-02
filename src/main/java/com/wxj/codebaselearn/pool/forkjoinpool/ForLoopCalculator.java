package com.wxj.codebaselearn.pool.forkjoinpool;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/8/2 0002 15:49
 */
public class ForLoopCalculator implements Calculator{
    @Override
    public long add(long[] numbers) {
        long total = 0;
        for (long i : numbers){
            total += i;
        }

        return total;
    }


    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1,10000000).toArray();

        Instant start = Instant.now();
        ForLoopCalculator forLoopCalculator = new ForLoopCalculator();
        long result = forLoopCalculator.add(numbers);
        Instant end = Instant.now();

        System.out.println("耗时："+ Duration.between(start,end).toMillis() + "ms");

        System.out.println("结果为："+ result);
    }
}