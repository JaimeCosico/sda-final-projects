package com.example.agilestore15.services;

import com.example.agilestore15.entities.Users;
import com.example.agilestore15.form.UsersForm;
import com.example.agilestore15.repositories.CustomUserDetailsRepository;
import com.example.agilestore15.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private SecureRandom secureRandom = new SecureRandom();

    public Users registerNewUser(UsersForm newUsers){
        Users users=new Users();
        users.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        users.setUserLastname(newUsers.getUserLastname());
        users.setUserFirstname(newUsers.getUserFirstname());
        users.setUserEmail(newUsers.getUserEmail());
        users.setUserAccount(newUsers.getUserAccount());

        return users;
    }

    public Users findUsersByEmail(UsersForm users){
        return userRepository.findUsersByUserEmail(users.getUserEmail());
    }

    //Shows all the users in the database
    public List<Users> showAllUsers() {

        return (List<Users>)userRepository.findAll();
    }

    public void save(Users users){
        userRepository.save(users);
    }
}
