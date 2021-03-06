package com.javaMentor.bootRest.controller;

import com.javaMentor.bootRest.model.User;
import com.javaMentor.bootRest.service.RoleService;
import com.javaMentor.bootRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/api")
public class AdminApiController {
    UserService userService;
    RoleService roleService;

    @Autowired
    public AdminApiController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers () {
        List<User> users = userService.getAllUsers();
        ResponseEntity responseEntity;
        if (users != null && !users.isEmpty()) {
            responseEntity = new ResponseEntity(users, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> showUser (@PathVariable ("id") Long id) {
        User user = userService.getUserById(id);
        ResponseEntity responseEntity;
        if (user != null) {
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/users")
    public void addNewUser(@RequestBody User user) {
        userService.add(user);
    }

    @PutMapping("/users")
    public void editUser(@RequestBody User user) {
        userService.edit(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
