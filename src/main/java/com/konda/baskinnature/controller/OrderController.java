package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.Order;
import com.konda.baskinnature.model.Status;
import com.konda.baskinnature.model.StockObject;
import com.konda.baskinnature.model.StockObjectList;
import com.konda.baskinnature.service.implementations.OrderServiceImpl;
import com.konda.baskinnature.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @PostMapping("/{invoice}")
    public ResponseEntity<Order> addOrder(@RequestBody Order order, @PathVariable String invoice) {
        return ResponseEntity.ok(orderService.addOrder(order, invoice));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @PostMapping("/update/{id}/{code}")
    public ResponseEntity<Order> setOrderStatus(@PathVariable String id, @PathVariable int code) {
        return ResponseEntity.ok(orderService.setOrderStatus(id, code));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable String id){
        return ResponseEntity.ok(orderService.getOrdersByUser(id));
    }

    @PostMapping("/stock")
    public void updateStock(@RequestBody StockObjectList stockObjectList){
        orderService.updateStock(stockObjectList);
    }
}

