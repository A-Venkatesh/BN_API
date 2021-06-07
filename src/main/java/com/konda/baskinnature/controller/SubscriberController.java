package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.Subscriber;
import com.konda.baskinnature.service.implementations.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcribers")
public class SubscriberController {

    @Autowired
    private SubscriberServiceImpl subscriberService;

    @PostMapping
    public ResponseEntity<Subscriber> createSubscriber(@RequestBody Subscriber subscriber) {
        return ResponseEntity.ok(subscriberService.createSubscriber(subscriber));
    }

    @GetMapping
    public ResponseEntity<List<Subscriber>> getSubscribers() {
        return ResponseEntity.ok(subscriberService.getSubscribers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> getSubscriber(@PathVariable String id) {
        return ResponseEntity.ok(subscriberService.getSubscriber(id));
    }
}
