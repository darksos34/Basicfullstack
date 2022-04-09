package com.example.basicfullstack;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(	name = "users", // Create database table named users
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"), // Username must be unique
                @UniqueConstraint(columnNames = "email") // Email address must be unique
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //max characters
    @Column(name = "username")
    private String username;

    @Column(name = "email")

    //@Size(max = 25)
    private String email;

    @Column(name = "password")
    private String password;

    //profile?
    //Role?
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}