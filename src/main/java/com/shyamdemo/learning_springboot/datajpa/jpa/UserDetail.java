package com.shyamdemo.learning_springboot.datajpa.jpa;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    public UserDetail() {

    }

    public UserDetail(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
