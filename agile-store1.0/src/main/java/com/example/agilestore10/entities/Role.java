package com.example.agilestore10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    private Admin admin;
    @OneToOne
    private Users users;
    private String roleName;

    public Role(Admin admin, String roleName) {
        this.admin = admin;
        this.roleName = roleName;
    }

    public Role(Users users, String roleName) {
        this.users = users;
        this.roleName = roleName;
    }
}
