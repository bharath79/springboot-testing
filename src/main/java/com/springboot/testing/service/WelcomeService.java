package com.springboot.testing.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String sayName(String name){
        return "hello "+name;
    }
}
