package com.wxj.codebaselearn.designpatterns.strategy.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/29 0029 14:24
 */
public class TestDemoStrategy {
    public static void main(String[] args) {

        //选择并创建需要使用的策略对象
        MemberStrategy strategy = new IntermediateMemberStrategy();
        ////创建环境
        Price price = new Price(strategy);
        // 计算价格
        double quote = price.quote(100);

        System.out.println("图书优惠后的价格：" + quote);
    }
}