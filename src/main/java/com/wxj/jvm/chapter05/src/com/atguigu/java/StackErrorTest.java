package com.wxj.jvm.chapter05.src.com.atguigu.java;

/**
 * 演示栈中的异常:StackOverflowError
 * @author shkstart
 * @create 2020 下午 9:08
 *
 *  默认情况下：count : 11420 11423
 *  设置栈的大小： -Xss256k : count : 2465 2458
 */
public class StackErrorTest {
    private static int count = 1;
    public static void main(String[] args) {
        // 11423
        System.out.println(count);
        count++;
        main(args);
    }

}
