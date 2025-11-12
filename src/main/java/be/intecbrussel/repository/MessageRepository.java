package be.intecbrussel.repository;
import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MessageRepository {

    public void save(Message message) {
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
    }

    public Optional<Message> findById(int id){
        EntityManager em = JpaConfig.getEntityManager();
        Message message = em.find(Message.class, id);
        return Optional.ofNullable(message);
    }

    public List<Message> findAll(){
        EntityManager em = JpaConfig.getEntityManager();
        Message message = em.find(Message.class, 1); // de eerste element wil ik vinden
        return Arrays.asList(message);
    }

    public void updateById(int id){
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        Message message = em.find(Message.class, id);
        message = em.merge(message);
        em.getTransaction().commit();
    }
    public void deleteById(int id){
        EntityManager em = JpaConfig.getEntityManager();
        em.getTransaction().begin();
        Message message = em.find(Message.class, id);
        message = em.merge(message);
        em.getTransaction().commit();
    }
}
