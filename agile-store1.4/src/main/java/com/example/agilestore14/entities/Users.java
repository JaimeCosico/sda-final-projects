package com.example.agilestore14.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message="Lastname is required.")
    private String userLastname;
    @NotEmpty(message="Firstname is required.")
    private String userFirstname;
    @NotEmpty(message="Email is required.")
    private String userEmail;
    @NotEmpty(message="Please select a role.")
    private Enum role;

    public Users(String userLastname, String userFirstname, String userEmail, Enum role) {
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userEmail = userEmail;
        this.role = role;
    }
}
