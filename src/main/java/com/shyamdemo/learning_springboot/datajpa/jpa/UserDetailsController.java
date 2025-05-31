package com.shyamdemo.learning_springboot.datajpa.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("jpa/")
@RestController
public class UserDetailsController {


    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDetail>> getUsers() {
        userDetailsService.insertUser();
        List<UserDetail> resList = userDetailsService.getUsers();
        return ResponseEntity.ok(resList);
    }
}
