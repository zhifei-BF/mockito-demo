package com.hershel.mockitodemo.test;

import com.hershel.mockitodemo.pojo.User;
import com.hershel.mockitodemo.repository.UserRepository;
import com.hershel.mockitodemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Test5 {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void test1() {
        User expectedUser = new User(222L, "hershel", 23);
        when(userRepository.findUserById(222L)).thenReturn(expectedUser);
        User actualUser = userService.findUserById(222L);
        assertEquals(expectedUser, actualUser);
    }


}
