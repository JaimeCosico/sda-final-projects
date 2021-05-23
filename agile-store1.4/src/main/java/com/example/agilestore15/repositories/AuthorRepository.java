package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
