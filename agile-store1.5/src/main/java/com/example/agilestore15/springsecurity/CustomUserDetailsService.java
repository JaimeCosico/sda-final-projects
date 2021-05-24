package com.example.agilestore15.springsecurity;

import com.example.agilestore15.entities.Users;
import com.example.agilestore15.repositories.CustomUserDetailsRepository;
import com.example.agilestore15.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomUserDetailsRepository customUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = customUserDetailsRepository.findByEmail(username);
        if(users==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(users);
    }
}
