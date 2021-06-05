package com.example.agilestore15.form;
import com.example.agilestore15.entities.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersForm {
    private long id;
    @NotEmpty
    @Size(min = 2, max = 50, message = "Length of Lastname should be in between 2 to 50")
    private String userLastname;
    @NotEmpty
    @Size(min = 2, max = 50, message = "Length of Firstname should be in between 2 to 50")
    private String userFirstname;
    @NotEmpty(message = "Email field should not be empty")
    @Email(regexp = "^(.+)@(.+)$", message = "Invalid email pattern, use the name@domain pattern ")
    private String userEmail;
    private UserAccount userAccount;

    public UsersForm(String userLastname, String userFirstname, String userEmail, UserAccount userAccount) {
        this.userLastname = userLastname;
        this.userFirstname = userFirstname;
        this.userEmail = userEmail;
        this.userAccount = userAccount;
    }
}


