package com.shyamdemo.learning_springboot.datajpa.one_to_many_unidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order1Repository extends JpaRepository<Order1, Long> {

}
