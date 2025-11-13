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
        User jan = new User("Jan", "Peeters", "Kerkstraat 5","Gent");
        User els = new User("Els", "Vermeulen", "Markt 10", "Brugge");

        userService.createUser(jan);
        userService.createUser(els);
        System.out.println("\uD83D\uDC64\u200B gebruikers aangemaakt");
        System.out.println(" - " + jan.getFirstName() + " " + jan.getLastName() + jan.getCity());
        System.out.println(" - " + els.getFirstName() + " " + els.getLastName()+ els.getCity());
        System.out.println("---------------------------------------");

        // Jan stuurt een bericht naar Els
        Message m1 = new Message(jan, els, "Hallo Els!", "Hoe gaat het?");
        messageService.sendMessage(m1);
        System.out.println(" \uD83D\uDCE9\u200B " + jan.getFirstName() + " stuurt een bericht naar " + els.getFirstName() + " : ");
        System.out.println(" onderwerp: " + m1.getSubject());
        System.out.println(" inhoud: " + m1.getContent());
        System.out.println("----------------------------");

        // Els antwoord op Jan
        Message m2 = new Message(els,jan," Re: Hallo Jan! "," Alles goed! en met jou?");
        messageService.sendMessage(m2);
        System.out.println("\uD83D\uDCE9\u200B " + els.getFirstName() + " anwoordt:");
        System.out.println( " onderwerp: " + m2.getSubject());
        System.out.println(" inhoud: " + m2.getContent());
        System.out.println("------------------------------");


        // Toon alle berichten
        System.out.println("📜 Alle berichten in systeem:");
        messageService.findAllMessages();




    }
}
