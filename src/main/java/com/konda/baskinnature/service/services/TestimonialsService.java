package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Testimonials;

import java.util.List;

public interface TestimonialsService {
    Testimonials createTestmony(Testimonials testimonials);
    Testimonials updateTestmony(Testimonials testimonials, String id);
    Testimonials getTestmony(String id);
    List<Testimonials> getTesmonies();
    String deleteTesmonials(String id);
}
