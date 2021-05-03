package com.wxj.codebaselearn.spring.constructorinjection;

/*
    构造器注入的 解决不了循环依赖的问题。 想想俄罗斯套娃
 */
public class ClientConstructor {
    public static void main(String[] args) {

        // 想创建A 对象，但是需要传入 B 对象，但是创建了B对象，这时 B 又需要A,我靠，这是
        // 俄罗斯套娃呀，
//        new ServiceA(new ServiceB(new ServiceA()));
    }
}
