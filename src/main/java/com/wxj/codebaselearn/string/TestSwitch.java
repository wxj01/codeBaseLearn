package com.wxj.codebaselearn.string;

import org.junit.Test;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO  switch case 情況对应的方法是空的时候，
 *  会走default的 对应的方法
 * @date 2022/3/14 0014 10:08
 */
public class TestSwitch {

    @Test
    public void test(){
        int i = 3;
        switch(i){
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:

            default:
                System.out.println("default");
        }
    }
}