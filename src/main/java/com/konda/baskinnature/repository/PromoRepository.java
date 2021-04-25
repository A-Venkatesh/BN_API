package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Promo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromoRepository extends MongoRepository<Promo,String> {
}
