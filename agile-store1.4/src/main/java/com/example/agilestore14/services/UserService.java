package com.example.agilestore14.services;

import com.example.agilestore14.entities.Role;
import com.example.agilestore14.entities.Users;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private Map<Long, Users> usersMap = new HashMap<>();
    private SecureRandom secureRandom = new SecureRandom();

    //adding of new users; it will return the Users object type.
    public Users addNewUsers(Users newUsers){
        Users users=new Users();
        users.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        users.setUserLastname(newUsers.getUserLastname());
        users.setUserFirstname(newUsers.getUserFirstname());
        users.setUserEmail(newUsers.getUserEmail());
        users.setRole(Role.USER);
        usersMap.put(users.getId(),users);
        return users;
    }
    //Shows all the users in the database
    public List<Users> showAllUsers() {
        return usersMap.values().stream().collect(Collectors.toList());
    }
}
