package com.example.Urbantelegram.models;

import javax.persistence.*;


@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer r_ID;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // list of messages

    @Column(name = "password")
    private String password;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    public Room(Integer r_ID, User owner, String password, String title, String description) {
        this.r_ID = r_ID;
        this.owner = owner;
        this.password = password;
        this.title = title;
        this.description = description;
    }

    public Integer getR_ID() {
        return r_ID;
    }

    public void setR_ID(Integer r_ID) {
        this.r_ID = r_ID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Room{" +
                "r_ID=" + r_ID +
                ", owner=" + owner +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
