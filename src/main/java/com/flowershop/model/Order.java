package com.flowershop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order {

    @Id
    private String id;
    private String userId; //Link to User
    private List<OrderItem> items;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String status; // e.g., "Pending", "Shipped", "Delivered"
}
