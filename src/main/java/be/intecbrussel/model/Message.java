package be.intecbrussel.model;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Message")
public class Message { // eigenaar
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "messageId")
    private int id; // primary key
    @Column(name = "subject")
    private String subject;
    @Column(name = "content")
    private String content;


    @ManyToOne
    @JoinColumn(name = "fromUserId")
    private User fromUser;
    @ManyToOne
    @JoinColumn(name = "touserId")
    private User toUser;


    public Message(User fromUser, User toUser, String subject, String content) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.subject = subject;
        this.content = content;


    }


    public Message() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Message message)) return false;
        return id == message.id && Objects.equals(subject, message.subject) && Objects.equals(content, message.content) && Objects.equals(fromUser, message.fromUser) && Objects.equals(toUser, message.toUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, content, fromUser, toUser);
    }
}
