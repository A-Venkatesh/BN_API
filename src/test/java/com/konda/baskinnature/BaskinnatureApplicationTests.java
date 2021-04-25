package com.konda.baskinnature;

import com.konda.baskinnature.model.Product;
import com.konda.baskinnature.service.implementations.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;


@SpringBootTest
class BaskinnatureApplicationTests {
    @Autowired
    ProductServiceImpl productService;

    @Test
    void testAddProduct() {
    }
//    @Test
//    void testAddProduct() throws URISyntaxException {
//
//
//        RestTemplate restTemplate = new RestTemplate();
//        final String baseUrl = "http://localhost:8080/api/products";
//        URI uri = new URI(baseUrl);
//        Product product = new Product();
//        product.setTitle("title");
//        product.setDescription("<h1>des</h1>");
//        product.setFeatured(true);
//        product.setImage("https://res");
//        product.setPrice(220);
//
//        ArrayList<HashMap<String, String>> testVariants = new ArrayList<>();
//        HashMap<String, String> n = new HashMap<>();
//        n.put("a", "a");
//        n.put("b", "b");
//        testVariants.add(n);
//        product.setVariants(testVariants);
//
//        ArrayList<HashMap<String, String>> testTypes = new ArrayList<>();
//        HashMap<String, String> o = new HashMap<>();
//        o.put("a", "a");
//        o.put("b", "b");
//        testTypes.add(o);
//        product.setTypes(testTypes);
//
//        product.setCategoryId();
//        product.setPublished(true);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//
//        HttpEntity<Product> request = new HttpEntity<>(product, headers);
//
//        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
//
//        //Verify request succeed
//        Assertions.assertEquals(200, result.getStatusCodeValue());
//    }

}
