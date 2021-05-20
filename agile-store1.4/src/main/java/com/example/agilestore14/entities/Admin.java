package com.example.agilestore14.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String userEmail;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Admin(String userName, String userEmail, Role role) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.role = role;
    }
}
