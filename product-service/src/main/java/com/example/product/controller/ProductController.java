package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo){ this.repo = repo; }

    @GetMapping("/{id}")
    @Cacheable(value = "product", key = "#id")
    public Product getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }



    @PostMapping
    public Product create(@RequestBody Product p){
        return repo.save(p);
    }
}
