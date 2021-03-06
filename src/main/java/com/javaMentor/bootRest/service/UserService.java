package com.javaMentor.bootRest.service;

import com.javaMentor.bootRest.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void edit(User user);
    User getUserByUsername(String username);

    User getUserById(Long id);
}

