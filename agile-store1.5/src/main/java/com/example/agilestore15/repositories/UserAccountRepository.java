package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.UserAccount;
import com.example.agilestore15.springsecurity.SecurityUserDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long>     {

    @Query("SELECT u FROM UserAccount u WHERE u.username = :username")
    public UserAccount getUserAccountByUsername(@Param("username") String username);
}
