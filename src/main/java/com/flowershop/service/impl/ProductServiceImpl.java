package com.flowershop.service.impl;

import com.flowershop.model.Product;
import com.flowershop.repository.ProductRepository;
import com.flowershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException("Product not found")
        );
    }

    @Override
    public Product updateProduct(String productId, Product product) {
        Product existingProduct = getProductById(productId);
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStockQuantity(product.getStockQuantity());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(String productId) {
          productRepository.deleteById(productId);
    }

    @Override
    public void reduceStock(String productId, int quantity) {
        Product product = getProductById(productId);
        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock for product: " + productId);
        }
        product.setStockQuantity(product.getStockQuantity() - quantity);
        productRepository.save(product);
    }
}
