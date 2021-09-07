package com.wxj.testSomthing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/3 0003 11:04
 */
@Slf4j
public class TestBoolean {

    @Test
    public void testBoolean(){
        Map<String,Object> map = new HashMap<>();
        map.put("aaa",false);

        boolean aaa = (boolean) map.get("aaa");
        log.info("aaa:"+aaa);//aaa:false
    }
}