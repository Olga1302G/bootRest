package com.javaMentor.bootRest.dao;

import com.javaMentor.bootRest.model.Role;

import java.util.List;


public interface RoleDao {
    void add(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
}
