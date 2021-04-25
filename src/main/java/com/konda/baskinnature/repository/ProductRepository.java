package com.konda.baskinnature.repository;

import com.konda.baskinnature.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findProductBySlug(String slug);
    List<Product> findAllByCategoryId(String categoryId);

}
