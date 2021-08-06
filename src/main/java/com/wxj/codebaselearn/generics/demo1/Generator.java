package com.wxj.codebaselearn.generics.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/8/5 0005 9:54
 */

//定义一个泛型接口
public interface Generator<T> {

    public T next();
}
