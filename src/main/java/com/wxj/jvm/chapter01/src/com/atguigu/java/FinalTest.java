package com.wxj.jvm.chapter01.src.com.atguigu.java;

/**
 * 项目: JVMDemo
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2021-03-22 11:21
 **/
public class FinalTest {
    private Integer var;

    public static void main(String[] args) {
    }

    public void getNum(Integer var) {
        FinalTest3 finalTest3 = new FinalTest3();
        finalTest3.getAge(var);
    }

    class FinalTest3 {
        public Integer getAge(Integer var) {
            return var;
        }
    }


}
