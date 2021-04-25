package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Testimonials;
import com.konda.baskinnature.repository.TestmonialRepository;
import com.konda.baskinnature.service.services.TestimonialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestmonialsServiceImpl implements TestimonialsService {
    @Autowired
    TestmonialRepository testmonialRepository;

    @Override
    public Testimonials createTestmony(Testimonials testimonials) {
        return testmonialRepository.insert(testimonials);
    }

    @Override
    public Testimonials updateTestmony(Testimonials testimonials, String id) {
        return testmonialRepository.save(testimonials);
    }

    @Override
    public Testimonials getTestmony(String id) {
        return testmonialRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid id"));
    }

    @Override
    public List<Testimonials> getTesmonies() {
        return testmonialRepository.findAll();
    }

    @Override
    public String deleteTesmonials(String id) {
        testmonialRepository.deleteById(id);
        return "Sucess";
    }
}
