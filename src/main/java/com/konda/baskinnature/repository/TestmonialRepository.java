package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Testimonials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestmonialRepository extends MongoRepository<Testimonials, String> {
}
