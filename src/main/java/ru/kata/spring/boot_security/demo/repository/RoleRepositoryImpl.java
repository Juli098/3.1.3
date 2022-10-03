package ru.kata.spring.boot_security.demo.repository;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r ", Role.class)
                .getResultList();
    }
    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }
    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }

}
