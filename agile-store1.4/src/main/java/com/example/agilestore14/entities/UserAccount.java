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
public class UserAccount {
    @Id
    private long id;
    private String username;
    @NotEmpty(message="Password is required.")
    private String password;
    @NotEmpty(message="City is required.")
    private String city;
    @NotEmpty(message="Home address is required.")
    private String address;
    @NotEmpty(message="Image url is required.")
    private String avatarUrl;
    @NotEmpty(message="Please select a role.")
    @Enumerated(EnumType.STRING)
    private Role role;
    @NotEmpty(message="Please select a messaging preference.")
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
