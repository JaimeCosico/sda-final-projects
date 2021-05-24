package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomUserDetailsRepository extends JpaRepository<Users,Long> {
    @Query("SELECT u FROM Users u WHERE u.userEmail = ?1")
    public Users findByEmail(String email);
}
