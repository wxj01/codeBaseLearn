package com.wxj.codebaselearn.designpatterns.strategy.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 高级会员折扣类
 * @date 2021/7/29 0029 14:19
 */
public class AdvancedMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("高级会员打3折");
        return booksPrice * 0.3;
    }
}