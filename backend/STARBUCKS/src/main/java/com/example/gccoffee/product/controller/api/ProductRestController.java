package com.example.gccoffee.product.controller.api;

import com.example.gccoffee.product.service.vo.Category;
import com.example.gccoffee.product.service.vo.Product;
import com.example.gccoffee.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/v1/products")
    public List<Product> productList(@RequestParam Optional<Category> category) {
        return category
                .map(productService::getProductByCategory)
                .orElse(productService.getAllProducts());
    }
}
