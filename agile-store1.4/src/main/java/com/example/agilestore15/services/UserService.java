package com.example.agilestore15.services;

import com.example.agilestore15.entities.Users;
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

    //adding of new users; it will return the Users object type.
    public Users registerNewUser(Users newUsers){
        Users users=new Users();
        users.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        users.setUserLastname(newUsers.getUserLastname());
        users.setUserFirstname(newUsers.getUserFirstname());
        users.setUserEmail(newUsers.getUserEmail());
        users.setUserAccount(newUsers.getUserAccount());
        return users;
    }
    //Shows all the users in the database
    public List<Users> showAllUsers() {

        return (List<Users>)userRepository.findAll();
    }

    public void save(Users users){

        userRepository.save(users);
    }
}
