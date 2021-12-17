package com.springboot.testing.controller;

import com.springboot.testing.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

    private WelcomeService ws;

    public WelcomeController(WelcomeService ws){
        this.ws=ws;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(defaultValue = "bob") String name){
        return ws.sayName(name);
    }
}
