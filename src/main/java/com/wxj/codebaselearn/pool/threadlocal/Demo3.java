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
 * @date 2021/10/19 0019 14:16
 */
@Slf4j
public class Demo3 {

    // 创建一个操作Thread 中 存放请求任务追踪id 口袋对象
    static ThreadLocal<String> traceIdKD = new ThreadLocal<>();

    static AtomicInteger threadIndex = new AtomicInteger(1);

    //创建处理请求的线程池
    static ThreadPoolExecutor disposeRequestExeutor = new ThreadPoolExecutor(
            3,
            3,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("disposeRequestThread-" + threadIndex.getAndIncrement());
                return thread;
            }
    );

    // 记录日志
    public static void log(String msg){
        StackTraceElement stack[] = (new Throwable()).getStackTrace();

        //获取当前线程存放tranceId口袋中的内容
        String traceId = traceIdKD.get();
        log.info("****" + System.currentTimeMillis() + "[traceId:" + traceId + "],[线程:" + Thread.currentThread().getName() + "]," + stack[1] + ":" + msg);

    }

    // 模拟controller
    public static void controller(List<String> dataList){
        log("接受请求");
        service(dataList);
    }

    //模拟service
    public static void service(List<String> dataList){
        log("执行业务");
        dao(dataList);
    }

    // 模拟dao
    public static void dao(List<String> dataList){
        log("执行数据库操作");
        for (String s : dataList) {
            log("插入数据" + s + "成功");
        }
    }

    public static void main(String[] args) {
        //需要插入的数据
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dataList.add("数据" + i);
        }

        //模拟5个请求
        int requestCount = 5;
        for (int i = 0; i < requestCount; i++) {
            String traceId = String.valueOf(i);
            disposeRequestExeutor.execute(()->{
                //把traceId 放入口袋中
                traceIdKD.set(traceId);
            });
            try{
                controller(dataList);
            }finally {
                //将traceId从口袋中移除
                traceIdKD.remove();
            }
        }
        disposeRequestExeutor.shutdown();
    }

}