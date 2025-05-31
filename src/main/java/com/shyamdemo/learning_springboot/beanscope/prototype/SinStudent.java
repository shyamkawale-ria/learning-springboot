package com.shyamdemo.learning_springboot.beanscope.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("prototypeSinStudent")
public class SinStudent {

    @Autowired
    ProUser proUser;

    public SinStudent() {
        System.out.println("SinStudent initiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("SinStudent object hashCode: " + this.hashCode() + " ProUser object hashCode: " + proUser.hashCode());
    }
}
