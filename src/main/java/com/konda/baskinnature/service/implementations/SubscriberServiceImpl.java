package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Subscriber;
import com.konda.baskinnature.repository.SubscriberRepository;
import com.konda.baskinnature.service.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Override
    public Subscriber createSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    @Override
    public List<Subscriber> getSubscribers() {
        return subscriberRepository.findAll();
    }

    @Override
    public Subscriber getSubscriber(String id) {
        return subscriberRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
    }
}
