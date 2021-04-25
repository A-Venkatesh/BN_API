package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Promo;
import com.konda.baskinnature.repository.PromoRepository;
import com.konda.baskinnature.service.services.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromoServiceImpl implements PromoService {
    @Autowired
    PromoRepository promoRepository;

    @Override
    public Promo CreatePromos(Promo promo) {
        return promoRepository.insert(promo);
    }

    @Override
    public Promo UpdatePromos(Promo promo) {
        return promoRepository.save(promo);
    }

    @Override
    public Promo getPromos() {
        return promoRepository.findById("Promos").orElseThrow(() -> new RuntimeException("Cluster has no promos, create on Promo with id : Promos"));
    }
}
