package com.javaMentor.bootRest.dao;

import com.javaMentor.bootRest.model.Role;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return entityManager.createQuery(
                "select r from Role r where r.role = :name", Role.class)
                .setParameter("name", roleName)
                .getSingleResult();
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from roles",Role.class).getResultList();
    }

}
