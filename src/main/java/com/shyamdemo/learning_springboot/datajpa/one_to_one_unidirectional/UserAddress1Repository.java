package com.shyamdemo.learning_springboot.datajpa.one_to_one_unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddress1Repository extends JpaRepository<UserAddress1, Long> {
    
}
