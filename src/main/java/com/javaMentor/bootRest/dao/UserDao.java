package com.javaMentor.bootRest.dao;

import com.javaMentor.bootRest.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> getAllUsers();
    void deleteUserById(Long id);
    void edit(User user);

    User getUserById(Long id);
    User getUserByUsername(String username);

}