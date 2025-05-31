package com.shyamdemo.learning_springboot.datajpa.plainjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("jdbc/")
@RestController("jdbcUserController")
public class UserController {

    @Autowired
    UserJDBCService userJDBCService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        userJDBCService.createTable();
        userJDBCService.insertUser();
        return ResponseEntity.ok(userJDBCService.getUsers());
    }
}
