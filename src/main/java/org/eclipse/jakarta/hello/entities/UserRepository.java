package org.eclipse.jakarta.hello.entities;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    public List<User> findAll() {
        return em.createNamedQuery(User.Query.FIND_ALL, User.class).getResultList();
    }

    public User get(Long id) {
        return em.find(User.class, id);
    }

    public void create(User user) {
        em.persist(user);
    }
}
