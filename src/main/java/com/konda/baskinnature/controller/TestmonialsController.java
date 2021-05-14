package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.Testimonials;
import com.konda.baskinnature.service.implementations.TestmonialsServiceImpl;
import com.konda.baskinnature.service.services.TestimonialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testmonials")
@CrossOrigin("*")
public class TestmonialsController {
    @Autowired
    TestmonialsServiceImpl testmonialsService;

    @PostMapping
    public ResponseEntity<Testimonials> createTestmony(@RequestBody Testimonials testimonials) {
        return ResponseEntity.ok(testmonialsService.createTestmony(testimonials));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Testimonials> updateTestmony(@RequestBody Testimonials testimonials, @PathVariable String id) {
        return ResponseEntity.ok(testmonialsService.updateTestmony(testimonials, id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Testimonials> getTestmony(@PathVariable String id) {
        return ResponseEntity.ok(testmonialsService.getTestmony(id));
    }
    @GetMapping
    public ResponseEntity<List<Testimonials>> getTesmonies() {
        return ResponseEntity.ok(testmonialsService.getTesmonies());

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTesmonials(@PathVariable String id) {
        return ResponseEntity.ok(testmonialsService.deleteTesmonials(id));
    }
}
