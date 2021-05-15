package com.example.agilestore12.repositories;

import com.example.agilestore12.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product,Long> {

}
