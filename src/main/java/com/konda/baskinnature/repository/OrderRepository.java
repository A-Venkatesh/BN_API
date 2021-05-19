package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> getOrderByUserId (String id);
}
