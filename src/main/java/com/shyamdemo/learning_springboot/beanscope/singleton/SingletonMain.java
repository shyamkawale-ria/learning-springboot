package com.shyamdemo.learning_springboot.beanscope.singleton;

import com.shyamdemo.learning_springboot.LearningSpringbootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonMain {
    public static void main(String[] args) {
        System.out.println("This is singleton main");
        SpringApplication.run(SingletonMain.class, args);
    }
}
