package com.wxj.codebaselearn.string;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 测试空格
 * @date 2021/9/14 0014 10:42
 */
@Slf4j
public class Testkongge {
//    public static void main(String[] args) {
//        String str="a b dddd c";  //待判断的字符串
////        String reg="^[^\\s]{6,16}$";  //判断字符串中是否含有特定空格
//        System.out.println(str.contains(" "));
//    }


    @Test
    public void testSpilt(){
        String abc = "a,b,c,d,";
        log.info(abc.split(";")[0]);
    }
}