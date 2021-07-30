package com.wxj.codebaselearn.designpatterns.strategy.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 初级会员折扣类
 * @date 2021/7/29 0029 14:16
 */
public class PrimaryMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("初级会员没有折扣");

        return booksPrice;
    }
}