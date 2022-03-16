package com.wxj.codebaselearn.juc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/3/10 0010 8:46
 */
@Slf4j
public class TestAtomicInteger {

    @Test
    public void test(){
        AtomicInteger count = new AtomicInteger(1);

        count.getAndIncrement();
        log.info("count:"+ count.get());

    }

    @Test
    public void test2(){
        AtomicInteger count = new AtomicInteger(1);
        count.incrementAndGet();
        log.info("count:" + count.get());
    }

    @Test
    public void test3(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dtf.format(LocalDate.now());
        log.info(">>>:"+format);
    }
}