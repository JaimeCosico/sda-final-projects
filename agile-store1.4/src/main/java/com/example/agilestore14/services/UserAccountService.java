package com.example.agilestore14.services;

import com.example.agilestore14.entities.UserAccount;
import com.example.agilestore14.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    //adding of new users; it will return the Users object type.
    public UserAccount registerNewUserAccount(UserAccount newUserAccount){
        UserAccount userAccount=new UserAccount();
        userAccount.setId(newUserAccount.getId());
        userAccount.setUsername(newUserAccount.getUsername());
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

        return (List<UserAccount>)userAccountRepository.findAll();
    }

    public void save(UserAccount userAccount){
        userAccountRepository.save(userAccount);
    }
}
