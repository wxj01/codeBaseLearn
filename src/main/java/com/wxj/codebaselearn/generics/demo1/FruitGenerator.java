package com.wxj.codebaselearn.generics.demo1;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/8/5 0005 9:54
 */

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
public class FruitGenerator<T>  implements Generator<T>{
    @Override
    public T next() {
        return null;
    }
}