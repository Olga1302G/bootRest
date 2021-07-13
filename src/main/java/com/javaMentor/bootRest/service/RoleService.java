package com.javaMentor.bootRest.service;

import com.javaMentor.bootRest.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    void add(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
}
