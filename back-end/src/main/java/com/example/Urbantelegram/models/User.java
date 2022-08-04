package com.example.Urbantelegram.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "owner")
    @Column(name = "chatrooms")
    private List<Room> rooms;

    public User(String username, String password, List<Room> rooms) {
        this.username = username;
        this.password = password;
        this.rooms = rooms;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
