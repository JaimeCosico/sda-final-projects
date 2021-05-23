package com.example.agilestore14.form;
import com.example.agilestore14.entities.MessageChannelPreference;
import com.example.agilestore14.entities.Orders;
import com.example.agilestore14.entities.UserAccount;
import com.example.agilestore14.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersAccountForm {
    private long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private Enum role;
    @NotEmpty
    private String city;
    @NotEmpty
    private String address;
    @NotEmpty
    private String avatarUrl;
    @NotEmpty
    private MessageChannelPreference messageChannelPreference;
    @NotEmpty
    private Users user;
    @NotEmpty
    private List<Orders> orderList;

    public UsersAccountForm(String username, String password, Enum role, String city, String address, String avatarUrl, MessageChannelPreference messageChannelPreference, Users user, List<Orders> orderList) {
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


