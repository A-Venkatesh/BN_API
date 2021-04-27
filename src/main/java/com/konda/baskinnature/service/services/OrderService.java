package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Order;
import com.konda.baskinnature.model.Status;

import java.util.List;

public interface OrderService {
    Order addOrder(Order order, String invoice);

    List<Order> getOrders();

    Order getOrder(String id);

    Order setOrderStatus(String id, int code);
}
