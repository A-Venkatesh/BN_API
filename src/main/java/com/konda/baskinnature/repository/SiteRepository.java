package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SiteRepository extends MongoRepository<Site,String> {
}
