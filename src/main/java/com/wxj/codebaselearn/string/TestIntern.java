package com.wxj.codebaselearn.string;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/14 0014 14:49
 */
public class TestIntern {
    public static void main(String[] args) {

        // 创建2个对象，str持有的是new创建的对象引用
        // 1）驻留（intern）在字符串常量池中的对象
        // 2）new创建的对象
        String str = new String("abc");

        String str2 = "abc";

        // false，str为new创建的对象引用，str2为字符创常量池中的引用
        System.out.println(str == str2);

        // str修改为字符串常量池的引用，所以下面为true
        str = str.intern();
        // true
        System.out.println(str == str2);
    }
}