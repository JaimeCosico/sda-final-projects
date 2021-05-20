package com.example.agilestore14.repositories;

import com.example.agilestore14.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product,Long> {

}
