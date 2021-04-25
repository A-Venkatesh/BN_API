package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> addProducts(List<Product> products);
    Product updateProduct(Product product,String id);
    List<Product> getProducts();
    Product getProduct(String id);
    Product getProductBySlug(String slug);
    String deleteProduct(String id);
    String deleteAllProduct();
}
