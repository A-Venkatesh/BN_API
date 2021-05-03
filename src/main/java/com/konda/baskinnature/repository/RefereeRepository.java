package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Referee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RefereeRepository extends MongoRepository<Referee,String> {
}
