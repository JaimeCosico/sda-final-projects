package com.example.agilestore14.form;
import com.example.agilestore14.entities.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersForm {
    @NotEmpty
    private long id;
    @NotEmpty
    private String userLastname;
    @NotEmpty
    private String userFirstname;
    @NotEmpty
    private String userEmail;
    @NotEmpty
    private UserAccount userAccount;

    public UsersForm(String userLastname, String userFirstname, String userEmail, UserAccount userAccount) {
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userEmail = userEmail;
        this.userAccount = userAccount;
    }
}


