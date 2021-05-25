package com.example.agilestore15.form;
import com.example.agilestore15.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersAccountForm {
    private long id;
    private String username;
    @NotEmpty
    @Size(min = 6, max = 20, message = "Length of password should be in between 6 to 20")
    private String password;
    @NotNull(message="Please select a role.")
    private Role role;
    @NotEmpty
    @Size(min = 1, max = 85, message = "Length of City should be in between 1 to 85")
    private String city;
    @NotEmpty
    @Size(min = 6, max = 85, message = "Length of Address should be in between 6 to 255")
    private String address;
    @NotEmpty
    @Size(min = 6, max = 255, message = "Length of Address should be in between 6 to 255")
    private String avatarUrl;
    @NotNull(message="Please select a messaging preference.")
    private MessageChannelPreference messageChannelPreference;
    private Users user;
    private List<Orders> orderList;

    public UsersAccountForm(String username, String password, Role role, String city, String address, String avatarUrl, MessageChannelPreference messageChannelPreference, Users user, List<Orders> orderList) {
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


