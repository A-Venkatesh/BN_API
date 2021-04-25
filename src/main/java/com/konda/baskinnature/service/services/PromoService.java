package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Promo;

public interface PromoService {
    Promo CreatePromos(Promo promo);

    Promo UpdatePromos( Promo promo);

    Promo getPromos();
}
