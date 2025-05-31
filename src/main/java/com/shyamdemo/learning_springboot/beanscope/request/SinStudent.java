package com.shyamdemo.learning_springboot.beanscope.request;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("requestSinStudent")
public class SinStudent {

    @Autowired
    ReqUser reqUser;

    public SinStudent() {
        System.out.println("SinStudent initiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("SinStudent object hashCode: " + this.hashCode() + " ReqUser object hashCode: " + reqUser.hashCode());
    }
}