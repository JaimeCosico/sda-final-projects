package com.example.agilestore14.repositories;

import com.example.agilestore14.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
