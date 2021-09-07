package com.wxj.testSomthing;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/9/3 0003 13:28
 */
@Slf4j
public class TestStringBuilder {

    @Test
    public void test(){
        StringBuilder sb = new StringBuilder();
        sb.append("( T.").append("key").append(" ").append("op").append(":").append("key").append(")") .append( " or ");

        log.info("sb:"+ sb.toString());
//        sb.toString().indexOf("or")
        sb.toString().substring(0,sb.toString().indexOf("or"));
        log.info(sb.toString().substring(0,sb.toString().length()-3));
    }
}