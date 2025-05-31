package com.shyamdemo.learning_springboot.beanscope.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeMain {
    public static void main(String[] args) {
        System.out.println("This is prototype main");
        SpringApplication.run(PrototypeMain.class, args);
    }
}
