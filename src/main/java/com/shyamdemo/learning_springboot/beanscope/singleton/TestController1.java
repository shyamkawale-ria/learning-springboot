package com.shyamdemo.learning_springboot.beanscope.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("singleton/api1/")
public class TestController1 {

    @Autowired
    SinUser user;

    public TestController1() {
        System.out.println("TestController1 Initiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestController1 object hashCode: " + this.hashCode() +
                " User object hashCode: " + user.hashCode());
    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("fetchUser api invoked");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}