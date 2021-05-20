package com.example.agilestore14.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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

    @NotEmpty(message="Please select a role.")
    private Enum role;

    @NotEmpty(message="City is required.")
    private String city;

    @NotEmpty(message="Home address is required.")
    private String address;

    @NotEmpty(message="Image url is required.")
    private String avatarUrl;

    @NotEmpty(message="Please select a messaging preference.")
    @Enumerated(EnumType.STRING)
    private MessageChannelPreference messageChannelPreference;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private Users user;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true )
    private List<Orders> orderList;

    public UserAccount(String username, String password, Enum role, String city, String address, String avatarUrl, MessageChannelPreference messageChannelPreference, Users user, List<Orders> orderList) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.city = city;
        this.address = address;
        this.avatarUrl = avatarUrl;
        this.messageChannelPreference = messageChannelPreference;
        this.user = user;
        this.orderList = orderList;
    }
}
