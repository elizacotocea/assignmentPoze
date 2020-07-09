package io.fxbits.assignment2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fxbits.assignment2.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import io.fxbits.assignment2.entities.User;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(value=UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void save() throws Exception {
        User testUser = new User(10,null,null,randomString(200),null,null);
        //given
        doReturn(testUser).when(userService).saveUser(testUser);

        //when
        MockHttpServletRequestBuilder post=post("http://localhost:8080/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(testUser));
        ResultActions result=mockMvc.perform(post);

        //then
        result.andExpect(status().isBadRequest());


        User testUserOK = new User(10,"Ana","Oana","anaoana","oarika",new HashSet<>());
        //given
        doReturn(testUserOK).when(userService).saveUser(testUserOK);

        //when
        post=post("http://localhost:8080/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(testUserOK));
        result=mockMvc.perform(post);

        //then
        result.andExpect(status().isOk());
    }

    String randomString(final int length) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            char c = (char)(r.nextInt((int)(Character.MAX_VALUE)));
            sb.append(c);
        }
        return sb.toString();
    }
}