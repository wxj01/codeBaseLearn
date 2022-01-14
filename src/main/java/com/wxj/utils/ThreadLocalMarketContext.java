package com.wxj.utils;

import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 工商企业库参数上下文
 * @date 2022/1/14 0014 10:24
 */

public class ThreadLocalMarketContext implements AutoCloseable{

    static final ThreadLocal<Map<String,Object>> ctx = new ThreadLocal<>();

    public ThreadLocalMarketContext(Map<String,Object> paramMap) {
        ctx.set(paramMap);
    }

    public static  Map<String,Object> currentMarkParamMap (){
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}