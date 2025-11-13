package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Message;
import be.intecbrussel.repository.MessageRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class MessageService {

public static final MessageRepository messageRepository = new MessageRepository();

    public void sendMessage(Message message){
        EntityManager em = JpaConfig.getEntityManager();
        messageRepository.save(message);
        em.close();
    }

    public void findAllMessages(){
        EntityManager em = JpaConfig.getEntityManager();
        List<Message> messages = messageRepository.findAll();
        for(Message m: messages){
            System.out.println("Van: " + m.getFromUser().getFirstName() + " -> naar: " + m.getToUser().getFirstName()
            + " | onderwerp: " + m.getSubject() + " | inhoud: " + m.getContent());
        }
        em.close();

    }

    public void updateMessage(int id){
        EntityManager em = JpaConfig.getEntityManager();
        messageRepository.updateById(id);
        em.close();
    }

    public void removeMessage(int id){
        EntityManager em = JpaConfig.getEntityManager();
        messageRepository.deleteById(id);
        em.close();
    }
}
