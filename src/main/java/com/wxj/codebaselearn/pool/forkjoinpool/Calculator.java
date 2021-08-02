package com.wxj.codebaselearn.pool.forkjoinpool;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/8/2 0002 15:21
 */
public interface Calculator {

    /** 
     * @description: 把传进来的所有numbers 做求和处理 
     * @param: * @param: numbers 
     * @return: long 
     * @author wangxinjian
     * @date: 2021/8/2 0002 15:22
     */ 
    long add(long[] numbers);
}
