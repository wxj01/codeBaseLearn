package com.wxj.codebaselearn.pool.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/10/19 0019 9:47
 */
@Slf4j
public class Demo1 {
    static  AtomicInteger threadIndex = new AtomicInteger(1);

    //创建处理请求的线程池
    static ThreadPoolExecutor disposeRequestExecutor = new ThreadPoolExecutor(
            3,
            3,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("disposeRequestThread-" +  threadIndex.getAndIncrement());
                return thread;
            });
    
    // 记录日志
    public static void log(String msg){
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        log.info("***" + System.currentTimeMillis() + ",[线程:" + Thread.currentThread().getName() + "]," + stack[1] + ":" + msg);
    }
    
    // 模拟controller
    public static void controller(List<String> dataList){
        log("接受请求");
        service(dataList);
    }
    
    //模拟请求
    public static void service(List<String> dataList){
        log("执行业务请求");
        
        // 模拟插入数据
        for (String s :dataList) {
            log("插入数据" + s + "成功");
        }
    }

    public static void main(String[] args) {
        //需要插入的数据
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dataList.add("数据" + i);
        }

        // 模拟5个请求
        int requestCount = 5;
        for (int i = 0; i < requestCount; i++) {
            disposeRequestExecutor.execute(()->{
                controller(dataList);
            });
        }

        disposeRequestExecutor.shutdown();
    }
}