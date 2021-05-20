package com.example.agilestore14.entities;

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
    private String userFullName;
    private String userEmail;
    private Enum role;

    public Users(String userFullName, String userEmail, Enum role) {
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.role = role;
    }
}
