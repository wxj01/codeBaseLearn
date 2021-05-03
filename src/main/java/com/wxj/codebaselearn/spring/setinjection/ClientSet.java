package com.wxj.codebaselearn.spring.setinjection;

public class ClientSet {
    public static void main(String[] args) {

        // 创建A
        ServiceAA a = new ServiceAA();

        // 创建B
        ServiceBB b = new ServiceBB();

        // 将a 注入b 中
        b.setServiceAA(a);

        // 将 b 注入 a 中
        a.setServiceBB(b);
    }
}
