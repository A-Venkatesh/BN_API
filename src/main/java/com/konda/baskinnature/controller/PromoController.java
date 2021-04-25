package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.Promo;
import com.konda.baskinnature.service.implementations.PromoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promo")
@CrossOrigin("*")
public class PromoController {
    @Autowired
    PromoServiceImpl promoService;

    @PostMapping
    public ResponseEntity<Promo> CreatePromos(@RequestBody Promo promo) {
        System.out.println(promo);
        Promo createdPromo = promoService.CreatePromos(promo);
        return ResponseEntity.ok(createdPromo);
    }

    @PutMapping
    public ResponseEntity<Promo> UpdatePromos(@RequestBody Promo promo) {
        Promo updatePromo = promoService.UpdatePromos(promo);
        return ResponseEntity.ok(updatePromo);
    }

    @GetMapping
    public ResponseEntity<Promo> getPromos() {
        return ResponseEntity.ok(promoService.getPromos());
    }
}
