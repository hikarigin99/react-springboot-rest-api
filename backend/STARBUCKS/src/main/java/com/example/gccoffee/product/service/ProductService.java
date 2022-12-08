package com.example.gccoffee.product.service;

import com.example.gccoffee.product.dto.CreateProductRequest;
import com.example.gccoffee.product.vo.Category;
import com.example.gccoffee.product.vo.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product getProductById(UUID productId);

    List<Product> getProductByCategory(Category category);

    List<Product> getAllProducts();

    Product createProduct(CreateProductRequest createProductRequest);

    Product update(UUID productId, Product product);

    void deleteById(UUID productId);
}
