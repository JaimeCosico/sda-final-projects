package com.example.agilestore13.repositories;

import com.example.agilestore13.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product,Long> {

}
