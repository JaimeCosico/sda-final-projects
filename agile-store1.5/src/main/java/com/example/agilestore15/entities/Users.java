package com.example.agilestore15.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"user_email"})})
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 2, max = 50, message = "Length of Lastname should be in between 2 to 50")
    private String userLastname;

    @NotEmpty
    @Size(min = 2, max = 50, message = "Length of Firstname should be in between 2 to 50")
    private String userFirstname;

    @Column(name="user_email")
    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern, use the name@domain pattern ")
    private String userEmail;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="user_account_id",referencedColumnName = "id")
    private UserAccount userAccount;

    public Users(String userLastname, String userFirstname, String userEmail, UserAccount userAccount) {
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userEmail = userEmail;
        this.userAccount = userAccount;
    }
}
