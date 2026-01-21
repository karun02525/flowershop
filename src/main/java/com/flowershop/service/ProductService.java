package com.flowershop.service;

import com.flowershop.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(String productId);

    Product updateProduct(String productId, Product product);

    void deleteProduct(String productId);

    void reduceStock(String productId, int quantity);

}
