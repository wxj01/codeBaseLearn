package com.wxj.jvm.chapter13.src.com.atguigu.java1;

/**
 * @author shkstart  shkstart@126.com
 * @create 2020  0:49
 */
public class StringTest4 {
    public static void main(String[] args) {
        System.out.println();//2293
        System.out.println("1");//2318
        System.out.println("2");//2319
        System.out.println("3");//2320
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2328
        //如下的字符串"1" 到 "10"不会再次加载
        System.out.println("1");//2328
        System.out.println("2");//2328
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");//2304
    }
}

