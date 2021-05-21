package com.example.agilestore14.repositories;

import com.example.agilestore14.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
