package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users,Long>{
    Users findUsersByUserEmail(String userEmail);
}
