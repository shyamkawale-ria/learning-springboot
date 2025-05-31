package com.shyamdemo.learning_springboot.datajpa.jpa;

import java.util.List;

public interface UserDetailsService {

    public void insertUser();

    public List<UserDetail> getUsers();
}
