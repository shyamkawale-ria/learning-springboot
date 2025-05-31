package com.shyamdemo.learning_springboot.beanscope.request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RequestMain {
    public static void main(String[] args) {
        System.out.println("This is request main");
        SpringApplication.run(RequestMain.class, args);
    }
}
