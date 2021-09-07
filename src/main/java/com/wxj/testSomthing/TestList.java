package com.wxj.testSomthing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/3 0003 10:17
 */
@Slf4j
public class TestList {

    @Test
    public void testList2String(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        String name = String.join(",",list.toArray(new String[list.size()]));

        log.info("name:" + name); //name:a,b,c

    }

    @Test
    public void testList2String02(){
        List<String> list = new ArrayList<>();
        list.add("a");

        String name = String.join(",",list.toArray(new String[list.size()]));

        log.info("name:" + name); //name:a

    }

}