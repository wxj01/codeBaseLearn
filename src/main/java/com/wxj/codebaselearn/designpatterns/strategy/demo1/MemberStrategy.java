package com.wxj.codebaselearn.designpatterns.strategy.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 *
 *  假设现在要设计一个贩卖各类书籍的电子商务网站的购物车系统。
 *  一个最简单的情况就是把所有货品的单价乘上数量，但是实际情况肯定比这要复杂。
 *  比如，本网站可能对所有的高级会员提供每本20%的促销折扣；对中级会员提供每本10%的促销折扣；对初级会员没有折扣。
 *
 * 　　根据描述，折扣是根据以下的几个算法中的一个进行的：
 *
 * 　　算法一：对初级会员没有折扣。
 *
 * 　　算法二：对中级会员提供10%的促销折扣。
 *
 * 　　算法三：对高级会员提供20%的促销折扣
 *
 * @date 2021/7/29 0029 14:13
 */
public interface MemberStrategy {

    /** 
     * @description:  计算图书的价格
     * @param: * @param: booksPrice 图书的原价
     * @return: double  计算打折后的价格
     * @author wangxinjian
     * @date: 2021/7/29 0029 14:15
     */ 
    public double calcPrice(double booksPrice);
}
