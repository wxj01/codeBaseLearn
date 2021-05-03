package com.wxj.codebaselearn.spring.setinjection;

import org.springframework.stereotype.Component;

@Component
public class ServiceBB {

    private ServiceAA serviceAA;

    public void setServiceAA(ServiceAA serviceAA) {
        this.serviceAA = serviceAA;
        System.out.println("B 里面设置了A");
    }
}
