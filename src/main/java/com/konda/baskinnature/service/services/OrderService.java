package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.*;

import javax.mail.MessagingException;
import java.util.List;

public interface OrderService {
    Order addOrder(Order order, String invoice);

    List<Order> getOrders();

    Order getOrder(String id);

    Order setOrderStatus(String id, int code, UpdateDetails updateDetails) throws MessagingException;

    List<Order> getOrdersByUser(String id);

    void updateStock(StockObjectList stockObjectList);

    Order ReleaserOrder (String id, String razorpay_payment_id) throws MessagingException;
}
