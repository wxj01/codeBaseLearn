package com.wxj.codebaselearn.spring.setinjection;

import org.springframework.stereotype.Component;

@Component
public class ServiceAA {

    private ServiceBB serviceBB;

    public void setServiceBB(ServiceBB serviceBB) {
        this.serviceBB = serviceBB;
        System.out.println("A 里面设置了B");
    }
}
