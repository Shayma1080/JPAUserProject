package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Message;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserService {

    public static final UserRepository userRepository = new UserRepository();

    public void createUser(User user) {
        EntityManager em = JpaConfig.getEntityManager();
        userRepository.save(user);
        em.close();
    }

    public void findAllMessages(){
        EntityManager em = JpaConfig.getEntityManager();
        List<User> messages = userRepository.findAll();
        em.close();

    }

    public void updateMessage(int id){
        EntityManager em = JpaConfig.getEntityManager();
        userRepository.updateById(id);
        em.close();
    }

    public void removeMessage(int id){
        EntityManager em = JpaConfig.getEntityManager();
        userRepository.deleteById(id);
        em.close();
    }

}
