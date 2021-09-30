package com.wxj.testSomthing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/24 0024 13:05
 */
@Slf4j
public class TestString {

    @Test
    public void testStr2Int(){
        String str = "123";
        String str2 = "2020092800001"; //
        System.out.println(Integer.valueOf(str2).intValue());
    }
}