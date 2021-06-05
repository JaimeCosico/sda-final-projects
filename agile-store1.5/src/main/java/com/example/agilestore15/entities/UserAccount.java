package com.example.agilestore15.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAccount {
    @Id
    private long id;
    private String username;

    @NotEmpty
    @Size(min = 6, max = 255, message = "Length of password should be in between 6 to 255")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_account_roles",
            joinColumns = @JoinColumn(name = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles =new HashSet<>();

    @NotEmpty
    @Size(min = 1, max = 85, message = "Length of City should be in between 1 to 85")
    private String city;

    @NotEmpty
    @Size(min = 6, max = 255, message = "Length of Address should be in between 6 to 255")
    private String address;

    @NotEmpty
    @Size(min = 6, max = 255, message = "Length of Address should be in between 6 to 255")
    private String avatarUrl;

    @NotNull(message="Please select a messaging preference.")
    @Enumerated(EnumType.STRING)
    private MessageChannelPreference messageChannelPreference;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_account_user",
            joinColumns = @JoinColumn(name = "user_account_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Users user;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true )
    private List<Orders> orderList;
    @Column(name="enabled", columnDefinition = "BOOLEAN")
    private boolean enabled;

    public UserAccount(String username, String password, Set<Role> roles, String city, String address, String avatarUrl, MessageChannelPreference messageChannelPreference, Users user, List<Orders> orderList, boolean enabled) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.city = city;
        this.address = address;
        this.avatarUrl = avatarUrl;
        this.messageChannelPreference = messageChannelPreference;
        this.user = user;
        this.orderList = orderList;
        this.enabled = enabled;
    }
}
