package com.wxj.testSomthing;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 将时间 yyyyMMdd + "00000" 转成 long
 * @date 2022/2/17 0017 9:21
 */
public class TestDateToLong {

    /**
     * @description: TODO 将时间 yyyyMMdd + "00000" 转成 long
     * @author wangxinjian
     * @date 2022/2/17 0017 9:28
     * @version 1.0
     */
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String format = dtf.format(now);
        String strNum = format + "00000";
        Long aLong = Long.valueOf(strNum);
        long a =  aLong + 1;
        System.out.println(aLong);
        System.out.println(a);

    }
}