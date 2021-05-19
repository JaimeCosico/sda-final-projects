package com.example.agilestore13.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String userEmail;

    public Users(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
