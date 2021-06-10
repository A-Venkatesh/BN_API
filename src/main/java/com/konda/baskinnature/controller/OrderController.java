package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.*;
import com.konda.baskinnature.service.implementations.OrderServiceImpl;
import com.konda.baskinnature.service.services.OrderService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
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
    public ResponseEntity<Order> setOrderStatus(@PathVariable String id, @PathVariable int code, @RequestBody UpdateDetails updateDetails) throws MessagingException {
        return ResponseEntity.ok(orderService.setOrderStatus(id, code, updateDetails));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable String id) {
        return ResponseEntity.ok(orderService.getOrdersByUser(id));
    }

    @PostMapping("/stock")
    public void updateStock(@RequestBody StockObjectList stockObjectList) {
        orderService.updateStock(stockObjectList);
    }

    @SneakyThrows
    @GetMapping("/release/{id}")
    public ResponseEntity<Order> releaseOrder(@PathVariable String id, @RequestParam String razorpay_payment_id) throws MessagingException {
        return ResponseEntity.ok(orderService.ReleaserOrder(id, razorpay_payment_id));
    }
}

