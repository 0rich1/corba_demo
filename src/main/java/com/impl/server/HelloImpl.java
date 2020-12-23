package com.impl.server;

import com.HelloPOA;

public class HelloImpl extends HelloPOA {
    public String sayHello() {
        System.out.println("client call in - " + new java.util.Date());
        return "hellow world";
    }
}
