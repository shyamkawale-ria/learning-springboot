package com.shyamdemo.learning_springboot.beanscope.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("prototypeTestController")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequestMapping("prototype/api/")
public class TestController {

    @Autowired
    ProUser proUser;

    @Autowired
    SinStudent sinStudent;

    public TestController() {
        System.out.println("TestController initiated");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestController1 object hashCode: " + this.hashCode() +
                " ProUser object hashCode: " + proUser.hashCode()
                + " SinStudent object hashCode: " + sinStudent.hashCode());

    }

    @GetMapping(path = "/fetchUser")
    public ResponseEntity<String> getUserDetails() {
        System.out.println("fetchUser api invoked");
        return ResponseEntity.status(HttpStatus.OK).body("");

    }
}
