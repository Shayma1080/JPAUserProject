package be.intecbrussel.repository;
import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Message;
import be.intecbrussel.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public void save(User user) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public Optional<User> findById(int id){
        EntityManager em = JpaConfig.getEntityManager();
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    public List<User> findAll(){
        EntityManager em = JpaConfig.getEntityManager();
        User user = em.find(User.class, 1); // de eerste element wil ik vinden
        return Arrays.asList(user);
    }

    public void updateById(int id){
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        user = em.merge(user);
        em.getTransaction().commit();
    }
    public void deleteById(int id){
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        user = em.merge(user);
        em.getTransaction().commit();
    }
}
