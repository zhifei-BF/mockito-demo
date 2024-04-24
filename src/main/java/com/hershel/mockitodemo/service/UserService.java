package com.hershel.mockitodemo.service;

import com.hershel.mockitodemo.pojo.User;
import com.hershel.mockitodemo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }
}
