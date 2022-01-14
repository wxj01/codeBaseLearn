package com.wxj.codebaselearn.pool.threadlocal;

import com.wxj.codebaselearn.algorithm.LRUCache;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 测试一下ThreadLocal 变量用Map的方式
 * @date 2022/1/14 0014 9:34
 */
@Slf4j
public class TestThreadLocalMap {

    ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String, Object>>(){
        @Override
        protected Map<String, Object> initialValue() {
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("corpName","小米");
            paramMap.put("scCode","scCode");
            paramMap.put("cleanLevel","cleanLevel");
            paramMap.put("id","id");
            paramMap.put("latch","latch");
            paramMap.put("tableName","tableName");
            paramMap.put("pcNum","pcNum");
            return paramMap;
        }
    };


    @Test
    public void test() throws InterruptedException {
        new Thread(() ->{
            Map<String, Object> map = threadLocal.get();
            log.info((String) map.get("corpName"));
            map.put("corpName","apple");
            threadLocal.set(map);

            log.info("修改后的值："+(String) threadLocal.get().get("corpName"));
        },"AAA").start();


        TimeUnit.SECONDS.sleep(1);
        
        new Thread(()->{
            Map<String, Object> map = threadLocal.get();
            log.info((String) map.get("corpName"));
        },"BBB").start();
    }
}