package com.shyamdemo.learning_springboot.datajpa.plainjdbc;

import java.util.List;

public interface UserJDBCService {
    public void createTable();
    public void insertUser();
    public List<User> getUsers();
}
