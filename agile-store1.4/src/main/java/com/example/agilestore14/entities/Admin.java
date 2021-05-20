package com.example.agilestore14.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message="Lastname is required.")
    private String adminLastName;
    @NotEmpty(message="Firstname is required.")
    private String adminFirstName;
    @NotEmpty(message="Email is required.")
    @Email(message="Email should be valid.")
    private String userEmail;
    @NotEmpty(message="Please select a role.")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Admin(String adminLastName, String adminFirstName, String userEmail, Role role) {
        this.adminLastName = adminLastName;
        this.adminFirstName = adminFirstName;
        this.userEmail = userEmail;
        this.role = role;
    }
}
