package com.wxj.testSomthing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/3 0003 9:15
 */
@Slf4j
public class TestInteger {

    @Test
    public void testInteger(){
        Map<String,Object> map = new HashMap<>();
        map.put("aaa",null);

        Integer aaa = (Integer) map.get("aaa");

        Integer bbb = (Integer) map.get("bbb");

        log.info("aaa:"+aaa); //aaa:null
        log.info("bbb:"+bbb);//bbb:null

    }
}