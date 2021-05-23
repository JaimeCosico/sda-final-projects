package com.example.agilestore14.repositories;

import com.example.agilestore14.entities.UserAccount;
import com.example.agilestore14.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
