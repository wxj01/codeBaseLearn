package com.wxj.codebaselearn.spring.test;

public class A {
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
        System.out.println("----A 创建成功");
    }
}
