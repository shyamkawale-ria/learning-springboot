package com.shyamdemo.learning_springboot.Dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Order {

    private final User user;

//    @Autowired
    public Order(User user) {
        System.out.println("Order Initialized");
        this.user = null;
    }
}
