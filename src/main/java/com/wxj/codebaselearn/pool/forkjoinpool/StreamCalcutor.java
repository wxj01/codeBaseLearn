package com.wxj.codebaselearn.pool.forkjoinpool;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/8/3 0003 19:23
 */
public class StreamCalcutor {

    public static void main(String[] args) {
        Instant start = Instant.now();
        long result = LongStream.rangeClosed(0, 10000000L).parallel().reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");

        System.out.println("结果为：" + result); // 打印结果50000005000000
    }
}