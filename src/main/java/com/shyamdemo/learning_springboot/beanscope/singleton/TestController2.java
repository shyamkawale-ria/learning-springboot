package com.shyamdemo.learning_springboot.beanscope.singleton;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("singleton/api2/")
public class TestController2 {

    @Autowired
    SinUser user;

    public TestController2() {
        System.out.println("TestController2 Initiated");
    }

    @PostConstruct
    public void init(){
        System.out.println("TestController2 object hashCode: " + this.hashCode() +
                " User object hashCode: " + user.hashCode());
    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("fetchUser api invoked");
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
