package com.example.agilestore10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount {
    @Id
    private String login;
    private String password;
    private String city;
    private String address;
    private String avatarUrl;
    @OneToOne
    private Role role;
    @Enumerated(EnumType.STRING)
    private MessageChannelPreference messageChannelPreference;
}
