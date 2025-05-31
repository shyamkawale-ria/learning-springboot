package com.shyamdemo.learning_springboot.controller;

import com.shyamdemo.learning_springboot.Dependency.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequestMapping(value = "/api/")
@RestController()
public class UserController {

    @Autowired
    User user;

    @GetMapping("fetchUserException")
    public String fetchUserException() throws ExecutionException, InterruptedException {
        try{
            user.fetchUserException().get();
        } catch (Exception e) {
            System.out.println("Execption occured: shyam: " + e.getMessage());
            throw e;
        }
        return "Shyam";
    }
}
