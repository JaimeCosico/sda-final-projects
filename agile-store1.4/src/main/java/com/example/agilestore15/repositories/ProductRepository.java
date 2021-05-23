package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product,Long> {

}
