package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriberRepository extends MongoRepository<Subscriber, String> {

}
