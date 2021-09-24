package com.wxj.testSomthing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/23 0023 16:10
 */
@Slf4j
public class TestLocalTime {

    @Test
    public void testLocal(){
//        int hour = LocalTime.now().getHour();
//        log.info("hour:"+ hour);
//
//        int hour1 = LocalTime.now().minusHours(6).getHour();
//        log.info("hour1:"+hour1);
//
        String format = LocalDateTime.now().minusHours(6).format(DateTimeFormatter.ofPattern("yyyyMMdd HH24:mi:ss"));
        log.info(format);

//        LocalTime localTime = LocalTime.now().minusHours(6);
//        System.out.println(localTime);

//        LocalDate curDay = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        System.out.println(curDay.format(formatter));
//        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(LocalDateTime.now().format(formatter));

//        log.info("abc:"+localTime.format(formatter));
    }
}