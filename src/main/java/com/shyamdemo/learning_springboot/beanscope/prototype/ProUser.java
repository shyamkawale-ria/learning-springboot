package com.shyamdemo.learning_springboot.beanscope.prototype;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProUser {
    public ProUser() {
        System.out.println("ProUser Initiated");
    }

    @PostConstruct
    public void init() {
        System.out.println("ProUser object hashcode: " + this.hashCode());
    }
}
