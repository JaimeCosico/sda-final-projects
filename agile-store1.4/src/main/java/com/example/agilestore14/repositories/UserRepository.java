package com.example.agilestore14.repositories;

import com.example.agilestore14.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users,Long> {
}
