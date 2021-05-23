package com.example.agilestore15.entities;

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

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="user_account_id",referencedColumnName = "id")
    private UserAccount userAccount;

    public Users(String userLastname, String userFirstname, String userEmail, UserAccount userAccount) {
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userEmail = userEmail;
        this.userAccount = userAccount;
    }
}
