package com.example.gccoffee.product.controller;

import com.example.gccoffee.product.dto.CreateProductRequest;
import com.example.gccoffee.product.dto.UpdateProductRequest;
import com.example.gccoffee.product.vo.Product;
import com.example.gccoffee.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String productList(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    @GetMapping("/new")
    public String productSave(Model model) {
        return "new-product";
    }

    @PostMapping
    public String productSave(CreateProductRequest createProductRequest) {
        productService.createProduct(createProductRequest);
        return "redirect:/products";
    }

    @GetMapping("/{productId}")
    public String productDetails(@PathVariable UUID productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/{productId}/edit")
    public String productModify(@PathVariable UUID productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-edit";
    }

    @PostMapping("/{productId}/edit")
    public String productModify(@PathVariable UUID productId, @ModelAttribute UpdateProductRequest productRequest) {
        productService.update(productId, productRequest.toEntity());
        return "redirect:/products/" + productId;
    }

    @GetMapping("/{productId}/delete")
    public String productRemove(@PathVariable UUID productId) {
        productService.deleteById(productId);
        return "redirect:/products";
    }
}
