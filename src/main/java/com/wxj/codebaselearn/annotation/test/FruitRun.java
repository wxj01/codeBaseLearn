package com.wxj.codebaselearn.annotation.test;

import com.wxj.codebaselearn.annotation.processor.FruitInfoUtil;
import com.wxj.codebaselearn.annotation.userdefined.Banana;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 测试类
 * @date 2021/7/29 0029 11:03
 */
public class FruitRun {

    public static void main(String[] args) {
        FruitInfoUtil.getFruitInfo(Banana.class);
    }

}