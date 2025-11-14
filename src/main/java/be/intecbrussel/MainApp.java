package be.intecbrussel;

import be.intecbrussel.model.Message;
import be.intecbrussel.model.User;
import be.intecbrussel.repository.MessageRepository;
import be.intecbrussel.repository.UserRepository;
import be.intecbrussel.service.MessageService;
import be.intecbrussel.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class MainApp {
    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("userdb");
        EntityManager em = emf.createEntityManager();


        Message message = new Message();
        MessageRepository messageRepository = new MessageRepository();
        MessageService messageService = new MessageService();

        User user = new User();
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService();



        // Gebruikers aanmaken
        User jan = new User("Jan", "Peeters", "Kerkstraat 5","Gent");
        User els = new User("Els", "Vermeulen", "Markt 10", "Brugge");

        userService.createUser(jan);
        userService.createUser(els);
        log.info("\uD83D\uDC64\u200B gebruikers aangemaakt");
        log.info(" - {} {} {} ", jan.getFirstName(), jan.getLastName(), jan.getCity());
        log.info(" - {} {} {} ",  els.getFirstName(), els.getLastName(), els.getCity());
        log.info("---------------------------------------");

        // Jan stuurt een bericht naar Els
        Message m1 = new Message(jan, els, "Hallo Els!", "Hoe gaat het?");
        messageService.sendMessage(m1);

        log.info(" \uD83D\uDCE9\u200B {} stuurt een bericht naar {}:", jan.getFirstName(), els.getFirstName());
        log.info(" onderwerp: {}", m1.getSubject());
        log.info(" inhoud: {}", m1.getContent());
        log.info("----------------------------");

        // Els antwoord op Jan
        Message m2 = new Message(els,jan," Re: Hallo Jan! "," Alles goed! en met jou?");
        messageService.sendMessage(m2);
        log.info("\uD83D\uDCE9\u200B {} antwoord: ", els.getFirstName());
        log.info( " onderwerp: {} ", m2.getSubject());
        log.info(" inhoud: {}", m2.getContent());
        log.info("------------------------------");


        // Toon alle berichten
        log.info("📜 Alle berichten in systeem:");
        messageService.findAllMessages();




    }
}
