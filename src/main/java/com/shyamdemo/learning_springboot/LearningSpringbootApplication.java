package com.shyamdemo.learning_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class LearningSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringbootApplication.class, args);
    }
}
