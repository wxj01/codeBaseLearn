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
        long abc = 1;
        String str3 = "1.0";
        int integer = Integer.valueOf(str);
//        Long aLong = Long.valueOf(str3);  //java.lang.NumberFormatException: For input string: "1.0"
        double v = Double.parseDouble(str3);
        String[] arr = str3.split(".");
//        String a  = str3.split(".")[0];

        int aaa =  (int)Math.floor(Float.valueOf(str3));


        System.out.println( aaa );
//        System.out.println(v);
//        System.out.println(integer+ abc);
//        System.out.println(Integer.valueOf(str2).intValue());
    }
}