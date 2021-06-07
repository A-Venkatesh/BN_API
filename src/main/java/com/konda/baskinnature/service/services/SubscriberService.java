package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Subscriber;

import java.util.List;

public interface SubscriberService {
    Subscriber createSubscriber (Subscriber subscriber);
    List<Subscriber> getSubscribers ();
    Subscriber getSubscriber(String id);
}
