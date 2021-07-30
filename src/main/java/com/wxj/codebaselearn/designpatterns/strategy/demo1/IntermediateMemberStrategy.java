package com.wxj.codebaselearn.designpatterns.strategy.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 中级会员折扣类
 * @date 2021/7/29 0029 14:18
 */
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double booksPrice) {

        System.out.println("中级会员有半价的折扣！！！！，还不去升级会员");
        return booksPrice * 0.5;
    }
}