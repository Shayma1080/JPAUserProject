package be.intecbrussel.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "User")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id; // primary key
    @Column(name = "user_firstname")
    private String firstName;
    @Column(name = "user_lastname")
    private String lastName;
    @Column(name = "user_adress")
    private String adress;
    @Column(name = "user_city")
    private String city;

    @OneToMany(mappedBy = "fromUser")
    private List<Message> sentMessages;
    @OneToMany(mappedBy = "toUser")
    private List<Message> receivedMessages;

    public User(String firstName, String lastName, String adress, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.city = city;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", sentMessages=" + sentMessages +
                ", receivedMessages=" + receivedMessages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(adress, user.adress) && Objects.equals(city, user.city) && Objects.equals(sentMessages, user.sentMessages) && Objects.equals(receivedMessages, user.receivedMessages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adress, city, sentMessages, receivedMessages);
    }
}
