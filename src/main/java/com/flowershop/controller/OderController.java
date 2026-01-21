package com.flowershop.controller;

import com.flowershop.model.Order;
import com.flowershop.model.OrderItem;
import com.flowershop.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OderController {

    @Autowired
    private OderService oderService;

    @PostMapping
    public Order placeOrder(@RequestParam String userId, @RequestBody List<OrderItem> items) {
       return oderService.placeOrder(userId, items);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        return oderService.getOrdersByUserId(userId);
    }
}
