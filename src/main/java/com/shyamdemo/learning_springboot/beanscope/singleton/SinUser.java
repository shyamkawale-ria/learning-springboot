package com.shyamdemo.learning_springboot.beanscope.singleton;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SinUser {

    public SinUser() {
        System.out.println("SinUser Initiated!");
    }
}
