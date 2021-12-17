package com.springboot.testing.controller;

import com.springboot.testing.service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WelcomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WelcomeService ws;


    @Test
    void shouldGetDefaultWelcomeMessage() throws Exception {
        when(ws.sayName("bob")).thenReturn("hello bob");
        mockMvc.perform(get("/welcome"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello bob")));
        verify(ws).sayName("bob");
    }

    @Test
    void shouldGetCustomWelcomeMessage() throws Exception {
        when(ws.sayName("John")).thenReturn("hello John");
        mockMvc.perform(get("/welcome?name=John"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello John")));
        verify(ws).sayName("John");
    }
}