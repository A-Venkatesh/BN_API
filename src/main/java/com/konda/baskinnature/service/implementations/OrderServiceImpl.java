package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Order;
import com.konda.baskinnature.model.Product;
import com.konda.baskinnature.model.Status;
import com.konda.baskinnature.model.StockObject;
import com.konda.baskinnature.repository.OrderRepository;
import com.konda.baskinnature.repository.ProductRepository;
import com.konda.baskinnature.service.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

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
    public List<Order> getOrdersByUser(String id) {
        return orderRepository.getOrderByUserId(id);
    }

    @Override
    public void updateStock(List<StockObject> stockObjects) {
        for (StockObject item : stockObjects) {
            Product product = productRepository.findById(item.getId()).orElseThrow(() -> new RuntimeException("invalid object"));
            int result = product.getStockInUnits() - parseInt(item.getQuantity());
            if (result == 0) {
                product.setStockInUnits(0);
            } else {
                product.setStockInUnits(result);
            }
            product.setTypes(product.getTypes());
            product.setPublished(product.getPublished());
            product.setPrice(product.getPrice());
            product.setImage(product.getImage());
            product.setVariants(product.getVariants());
            product.setFeatured(product.getFeatured());
            product.setDescription(product.getDescription());
            product.setTitle(product.getTitle());
            product.setGenre(product.getGenre());
            product.setSlug(product.getSlug());
            product.setCategoryId(product.getCategoryId());
            product.setId(product.getId());
            product.setRating(product.getRating());
            productRepository.save(product);
        }
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
