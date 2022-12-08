package com.example.gccoffee.product.service;

import com.example.gccoffee.product.dto.CreateProductRequest;
import com.example.gccoffee.product.vo.Category;
import com.example.gccoffee.product.vo.Product;
import com.example.gccoffee.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("존재하는 아이디가 없습니다."));
    }

    @Override
    public List<Product> getProductByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product(UUID.randomUUID(), createProductRequest.productName(), createProductRequest.category(),
                createProductRequest.price(), createProductRequest.description(), createProductRequest.imgUrl(), LocalDateTime.now(), LocalDateTime.now());
        return productRepository.insert(product);
    }

    @Override
    public Product update(UUID productId, Product product) {
        return productRepository.update(product);
    }

    @Override
    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }
}
