package com.example.agilestore14.entities;

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
    private long id;
    private String username;
    private String password;
    private String city;
    private String address;
    private String avatarUrl;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private MessageChannelPreference messageChannelPreference;

    public UserAccount(String username, String password, String city, String address, String avatarUrl, Role role, MessageChannelPreference messageChannelPreference) {
        this.username = username;
        this.password = password;
        this.city = city;
        this.address = address;
        this.avatarUrl = avatarUrl;
        this.role = role;
        this.messageChannelPreference = messageChannelPreference;
    }
}
