package com.flowershop.service.impl;

import com.flowershop.model.Order;
import com.flowershop.model.OrderItem;
import com.flowershop.model.Product;
import com.flowershop.repository.OrderRepository;
import com.flowershop.service.OderService;
import com.flowershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class OderServiceImpl implements OderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Order placeOrder(String userId, List<OrderItem> items) {
        double totalAmount = 0.0;
        for (OrderItem item : items) {
            Product product = productService.getProductById(item.getProductId());
            if (product.getStockQuantity() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            productService.reduceStock(item.getProductId(), item.getQuantity());
            item.setPrice(product.getPrice());
            totalAmount += product.getPrice() * item.getQuantity();
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setItems(items);
        order.setTotalAmount(totalAmount);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }



    @Override
    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
