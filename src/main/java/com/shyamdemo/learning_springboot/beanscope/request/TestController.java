package com.shyamdemo.learning_springboot.beanscope.request;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("requestTestController")
@Scope("request")
@RequestMapping("request/api/")
public class TestController {

    @Autowired
    ReqUser reqUser;

    @Autowired
    SinStudent sinStudent;

    public TestController() {
        System.out.println("TestController initiated");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestController1 object hashCode: " + this.hashCode() +
                " ReqUser object hashCode: " + reqUser.hashCode()
                + " SinStudent object hashCode: " + sinStudent.hashCode());

    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("fetchUser api invoked");
        return ResponseEntity.status(HttpStatus.OK).body("");

    }
}
