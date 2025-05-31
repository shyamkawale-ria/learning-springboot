package com.shyamdemo.learning_springboot.datajpa.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public void insertUser() {
        UserDetail userDetail = new UserDetail("ram", 27);
        UserDetail newUserDetails = userDetailsRepository.save(userDetail);
        return;
    }

    @Override
    public List<UserDetail> getUsers() {
        Optional<UserDetail> user = userDetailsRepository.findById(1L);
        return new ArrayList<>(user.stream().toList());
    }
}
