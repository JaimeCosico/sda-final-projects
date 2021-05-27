package com.example.agilestore15.services;

import com.example.agilestore15.entities.Role;
import com.example.agilestore15.entities.UserAccount;
import com.example.agilestore15.form.UsersAccountForm;
import com.example.agilestore15.repositories.UserAccountRepository;
import com.example.agilestore15.springsecurity.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserAccountService implements UserDetailsService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    private SecureRandom secureRandom = new SecureRandom();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.getUserAccountByUsername(username);

        if (userAccount == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new SecurityUserDetails(userAccount);
    }

    //adding of new users; it will return the Users object type.
    public UserAccount registerNewUserAccount(UsersAccountForm newUserAccount){
        UserAccount userAccount=new UserAccount();
        userAccount.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        userAccount.setUsername(newUserAccount.getUsername());
        userAccount.setPassword(newUserAccount.getPassword());
        userAccount.setRoles((Set<Role>) newUserAccount.getRole());
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
