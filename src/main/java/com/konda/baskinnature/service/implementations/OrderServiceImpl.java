package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Order;
import com.konda.baskinnature.model.Status;
import com.konda.baskinnature.repository.OrderRepository;
import com.konda.baskinnature.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order, String invoice) {
        Order orderRequest = orderRepository.findById(invoice).orElse(null);
        if (orderRequest == (null)) {
            orderRepository.insert(order);
            return order;
        } else return orderRequest;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid ID"));
    }

    @Override
    public Order setOrderStatus(String id, int code) {
        Order orderRequest = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid ID"));

        switch (code) {
            case 1:
                orderRequest.setStatus(Status.CONFIRMED);
                break;
            case 2:
                orderRequest.setStatus(Status.DELIVERED);
                break;
            default:
                orderRequest.setStatus(Status.PENDING);
                break;
        }

        return orderRepository.save(orderRequest);
    }
}
