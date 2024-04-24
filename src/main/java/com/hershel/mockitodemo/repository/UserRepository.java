package com.hershel.mockitodemo.repository;

import com.hershel.mockitodemo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findUserById(Long id);
}
