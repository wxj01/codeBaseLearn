package com.wxj.codebaselearn.pool.threadlocal;

import com.wxj.codebaselearn.pool.threadlocal.service.TestService;
import com.wxj.codebaselearn.pool.threadlocal.service.impl.TestServiceImpl;
import com.wxj.codebaselearn.pool.threadlocal.thread.TestThread;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/14 0014 13:12
 */
public class TestThreadLocal002 {



    //创建处理请求的线程池
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            3,
            3,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("threadPoolExecutor-" + thread.getName());
                return thread;
            }
    );

    @Test
    public void test(){

        TestService testService = new TestServiceImpl();

        List<Map<String,Object>> list = new ArrayList<>();

        Map<String,Object> map = new HashMap<>();
        map.put("corpName","小米");
        map.put("num","1000W");
        map.put("corpLevel","A");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("corpName","华为");
        map2.put("num","2000W");
        map2.put("corpLevel","A");

        list.add(map);
        list.add(map2);

        list.forEach( objectMap -> {
            System.out.println(objectMap);
            threadPoolExecutor.submit(new TestThread((String) objectMap.get("corpName"),
                    (String) objectMap.get("num"),
                    (String) objectMap.get("corpLevel"),
                    testService));
        });


//        threadPoolExecutor.submit(new TestThread("小米", "1000W", "A", testService));


    }
}