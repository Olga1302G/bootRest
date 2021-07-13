package com.javaMentor.bootRest.service;

import com.javaMentor.bootRest.dao.RoleDao;
import com.javaMentor.bootRest.dao.UserDao;
import com.javaMentor.bootRest.model.Role;
import com.javaMentor.bootRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDao;
    private RoleDao roleDao;


    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;

    }

    @Override
    public void add(User user) {

        user.setRoles(updateRoles(user.getRoles()));
        userDao.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void edit(User user) {
        User oldUser = getUserById(user.getId());

        user.setRoles(updateRoles(user.getRoles()));
        userDao.edit(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    private List<Role> updateRoles(List<Role> roles) {
        if (roles == null) {
            return Collections.emptyList();
        }
        return roles.stream()
                .map(Role::getAuthority)
                .map(roleDao::getRoleByName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
