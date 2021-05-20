package com.example.agilestore14.services;

import com.example.agilestore14.entities.Admin;
import com.example.agilestore14.entities.Role;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private Map<Long, Admin> adminMap =new HashMap<>();
    private SecureRandom secureRandom = new SecureRandom();

    //adding of new users; it will return the Users object type.
    public Admin addNewAdmin(Admin newAdmin){
        Admin admin=new Admin();
        admin.setId(Long.parseLong(String.valueOf(Math.abs(secureRandom.nextInt()))));
        admin.setAdminLastName(newAdmin.getAdminLastName());
        admin.setAdminFirstName(newAdmin.getAdminFirstName());
        admin.setAdminEmail(newAdmin.getAdminEmail());
        admin.setRole(Role.ADMIN);
        adminMap.put(admin.getId(),admin);
        return admin;
    }

    //Shows all the users in the database
    public List<Admin> showAllUsers() {
        return adminMap.values().stream().collect(Collectors.toList());
    }


}
