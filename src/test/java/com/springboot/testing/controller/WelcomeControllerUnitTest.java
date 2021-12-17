package com.springboot.testing.controller;

import com.springboot.testing.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class WelcomeControllerUnitTest {

    //it can go only upto the controller level and cannot go to service hence  we mock service reply
    @Test
    void shouldWelcome() {
        WelcomeService ws = Mockito.mock(WelcomeService.class);
        when(ws.sayName("john")).thenReturn("hello john");
        WelcomeController wc =  new WelcomeController(ws);
        assertEquals("hello john",wc.welcome("john"));
    }
}