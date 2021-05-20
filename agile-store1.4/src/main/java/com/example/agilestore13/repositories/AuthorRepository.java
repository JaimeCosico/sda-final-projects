package com.example.agilestore13.repositories;

import com.example.agilestore13.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
