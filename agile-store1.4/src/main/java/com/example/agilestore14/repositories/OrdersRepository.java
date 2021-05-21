package com.example.agilestore14.repositories;

import com.example.agilestore14.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
