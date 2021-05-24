package com.example.agilestore15.services;

import com.example.agilestore15.entities.UserAccount;
import com.example.agilestore15.form.UsersAccountForm;
import com.example.agilestore15.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    private SecureRandom secureRandom = new SecureRandom();

    //adding of new users; it will return the Users object type.
    public UserAccount registerNewUserAccount(UsersAccountForm newUserAccount){
        UserAccount userAccount=new UserAccount();
        userAccount.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        userAccount.setUsername(newUserAccount.getUser().getUserEmail());
        userAccount.setPassword(newUserAccount.getPassword());
        userAccount.setRole(newUserAccount.getRole());
        userAccount.setCity(newUserAccount.getCity());
        userAccount.setAddress(newUserAccount.getAddress());
        userAccount.setAvatarUrl(newUserAccount.getAvatarUrl());
        userAccount.setMessageChannelPreference(newUserAccount.getMessageChannelPreference());
        userAccount.setUser(newUserAccount.getUser());
        return userAccount;
    }

    public List<UserAccount> showAllUserAccount() {
        UserAccount userAccount=new UserAccount();
        return (List<UserAccount>)userAccountRepository.findAll();
    }

    public void save(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }
}
