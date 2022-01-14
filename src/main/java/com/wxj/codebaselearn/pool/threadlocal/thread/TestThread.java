package com.wxj.codebaselearn.pool.threadlocal.thread;

import com.wxj.codebaselearn.pool.threadlocal.service.TestService;
import com.wxj.utils.ThreadLocalMarketContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/14 0014 13:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TestThread implements Callable {

    private String corpName;
    private String num;
    private String corpLevel;
    private Object service;

    @Override
    public String call() {

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("corpName",corpName);
        paramMap.put("num",num);
        paramMap.put("corpLevel",corpLevel);
        ThreadLocalMarketContext ctx = new ThreadLocalMarketContext(paramMap);

        TestService testService = (TestService) this.service;

        try{
            testService.cleanData();
        }finally {
            try {
                ctx.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "OK";
    }
}