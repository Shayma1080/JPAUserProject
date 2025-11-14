package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Message;
import be.intecbrussel.repository.MessageRepository;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageService {
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

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
            log.info("Van: {} -> naar: {} |onderwerp: {} | inhoud: {} ",
            m.getFromUser().getFirstName(),
            m.getToUser().getFirstName(),
            m.getSubject(),
            m.getContent());
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
