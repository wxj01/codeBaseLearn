package com.wxj.codebaselearn.pool.threadlocal.service.impl;

import com.wxj.codebaselearn.pool.threadlocal.service.TestService;
import com.wxj.utils.ThreadLocalMarketContext;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO threadLocal 学习
 * @date 2022/1/14 0014 13:11
 */
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public String cleanData() {
        Map<String, Object> map = ThreadLocalMarketContext.currentMarkParamMap();
        System.out.println("111");

        System.out.println("corpName:" + map.get("corpName"));
        System.out.println("num:" + map.get("num"));
        System.out.println("corpLevel:" + map.get("corpLevel"));

        System.out.println("222");

        return "OK";
    }
}