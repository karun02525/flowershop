package com.flowershop.service;

import com.flowershop.model.Order;
import com.flowershop.model.OrderItem;

import java.util.List;

public interface OderService {

    Order placeOrder(String userId, List<OrderItem> items);

    List<Order> getOrdersByUserId(String userId);

}
