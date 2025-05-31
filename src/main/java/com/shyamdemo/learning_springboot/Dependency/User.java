package com.shyamdemo.learning_springboot.Dependency;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Primary
@Component
public class User {

//    public final Order order;

    @PostConstruct
    public void initialize(){
        System.out.println("Bean has been constructed and dependencies have been injected");
    }

//    public User(){
//        System.out.println("User initialized default");
//    }

//    @Autowired
//    public User(Order order) {
//        this.order = order;
//        System.out.println("User Initialized");
//    }
//
//    public User(String str) {
//        this.order = null;
//        System.out.println("User Initialized str");
//    }

    public User(){
        System.out.println("User initialized");
    }


    @Async
    public CompletableFuture<Void> fetchUserException(){
        System.out.println("FetchUserException Async method invoked");
        try{
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            int i = 0;
            System.out.println("Result: ");
            System.out.println(5 / i);
            return CompletableFuture.completedFuture(null);
        } catch (Exception e) {
            return CompletableFuture.failedFuture(e);
        }
    }
}
