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

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class MainApp {
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
        User u1 = new User("Jan", "Peeters", "Kerkstraat 5","Gent");
        User u2 = new User("Els", "Vermeulen", "Markt 10", "Brugge");

        userService.createUser(u1);
        System.out.println("User 1 is created :" + u1.getFirstName() + " " + u1.getLastName());
        userService.createUser(u2);
        System.out.println("User 2 is created :" + u2.getFirstName() + " " + u2.getLastName());

        // Bericht aanmaken
        Message m1 = new Message(u1, u2, "Hallo", "Hoe gaat het?");


        // Berichten ophalen
        messageService.sendMessage(m1);
        System.out.println("Message 1: " + m1.getSubject() + " " +m1.getContent());



        //codes schrijven....


    }
}
