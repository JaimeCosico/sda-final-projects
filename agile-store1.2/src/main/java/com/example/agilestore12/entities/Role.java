package com.example.agilestore12.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
