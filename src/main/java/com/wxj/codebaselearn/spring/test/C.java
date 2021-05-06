package com.wxj.codebaselearn.spring.test;

public class C {
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public C() {
        System.out.println("C 已经被创建");
    }
}
