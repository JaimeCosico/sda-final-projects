package com.example.agilestore15.repositories;

import com.example.agilestore15.entities.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
