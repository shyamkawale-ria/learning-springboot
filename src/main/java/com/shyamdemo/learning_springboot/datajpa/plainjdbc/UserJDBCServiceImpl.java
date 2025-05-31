package com.shyamdemo.learning_springboot.datajpa.plainjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJDBCServiceImpl implements UserJDBCService {

    @Autowired
    UserJDBCRepository userJDBCRepository;

    @Override
    public void createTable() {
        userJDBCRepository.createTable();
    }

    @Override
    public void insertUser() {
        userJDBCRepository.insertUser("shyam", 25);
    }

    @Override
    public List<User> getUsers() {
        return userJDBCRepository.getUsers();
    }
}
