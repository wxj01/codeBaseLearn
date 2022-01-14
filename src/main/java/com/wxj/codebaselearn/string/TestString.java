package com.wxj.codebaselearn.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2022/1/14 0014 10:53
 */
@Slf4j
public class TestString {

    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();

        map.put("aaa",null);

        String xxx = (String) map.get("aaa");
        log.info("xxx的值为空：" + xxx);

    }
}