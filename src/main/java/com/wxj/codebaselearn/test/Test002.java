package com.wxj.codebaselearn.test;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/12/21 0021 19:20
 */
public class Test002 {

    @Test
    public void test(){

//        java.util.ConcurrentModificationException

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String item: list) {
//            if ("1".equals(item)){
//                list.remove(item);
//            }

            if ("2".equals(item)){
                list.remove(item);
            }
        }

        list.stream().forEach(System.out::println);
    }
}