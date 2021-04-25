package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.Product;
import com.konda.baskinnature.service.implementations.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product insertedProduct = productService.addProduct(product);
        return ResponseEntity.ok(insertedProduct);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        List<Product> productList = productService.addProducts(products);
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable String id) {
        Product updatedProduct = productService.updateProduct(product, id);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product/{slug}")
    public ResponseEntity<Product> getProductBySlug(@PathVariable String slug) {
        Product product = productService.getProductBySlug(slug);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        String res = productService.deleteProduct(id);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllProducts() {
        String res = productService.deleteAllProduct();
        return ResponseEntity.ok(res);
    }

}
