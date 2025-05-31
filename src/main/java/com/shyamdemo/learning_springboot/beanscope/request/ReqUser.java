package com.shyamdemo.learning_springboot.beanscope.request;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ReqUser {
    public ReqUser() {
        System.out.println("ReqUser Initiated");
    }

    @PostConstruct
    public void init() {
        System.out.println("ReqUser object hashcode: " + this.hashCode());
    }
}
