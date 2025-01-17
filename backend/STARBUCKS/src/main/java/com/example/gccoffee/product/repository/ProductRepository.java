package com.example.gccoffee.product.repository;

import com.example.gccoffee.product.service.vo.Category;
import com.example.gccoffee.product.service.vo.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

    List<Product> findAll();

    Product insert(Product product);

    Product update(Product product);

    Optional<Product> findById(UUID productId);

    Optional<Product> findByName(String productName);

    List<Product> findByCategory(Category category);

    void deleteAll();

    void deleteById(UUID productId);
}
