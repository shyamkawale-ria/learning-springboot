package com.shyamdemo.learning_springboot.datajpa.one_to_one_unidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_details1")
public class UserDetail1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private UserAddress1 userAddress;

    // Constructors
    public UserDetail1() {
    }

    //getters and setters
}
