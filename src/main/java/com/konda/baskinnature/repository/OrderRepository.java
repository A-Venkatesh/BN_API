package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {

}
