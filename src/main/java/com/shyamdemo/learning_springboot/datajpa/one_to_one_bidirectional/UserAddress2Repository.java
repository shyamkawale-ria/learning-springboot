package com.shyamdemo.learning_springboot.datajpa.one_to_one_bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddress2Repository extends JpaRepository<UserAddress2, Long> {

}
