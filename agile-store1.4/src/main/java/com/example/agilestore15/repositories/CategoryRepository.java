package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
