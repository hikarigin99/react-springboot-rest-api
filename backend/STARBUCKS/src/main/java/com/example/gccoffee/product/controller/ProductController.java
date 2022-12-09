package com.example.gccoffee.product.controller;

import com.example.gccoffee.product.controller.dto.CreateProductRequest;
import com.example.gccoffee.product.controller.dto.UpdateProductRequest;
import com.example.gccoffee.product.service.vo.Product;
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
    public String lists(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "product-list";
    }

    @GetMapping("/new")
    public String addProduct(Model model) {
        return "new-product";
    }

    @PostMapping
    public String addProduct(CreateProductRequest createProductRequest) {
        productService.createProduct(createProductRequest);
        return "redirect:/products";
    }

    @GetMapping("/{productId}")
    public String detailProduct(@PathVariable UUID productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/{productId}/edit")
    public String editProduct(@PathVariable UUID productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product-edit";
    }

    @PostMapping("/{productId}/edit")
    public String editProduct(@PathVariable UUID productId, @ModelAttribute UpdateProductRequest productRequest) {
        productService.update(productId, productRequest.toEntity());
        return "redirect:/products/" + productId;
    }

    @GetMapping("/{productId}/delete")
    public String deleteProduct(@PathVariable UUID productId) {
        productService.deleteById(productId);
        return "redirect:/products";
    }
}
