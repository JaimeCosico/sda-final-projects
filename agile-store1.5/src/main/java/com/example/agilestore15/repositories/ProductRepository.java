package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository <Product,Long> {

}
