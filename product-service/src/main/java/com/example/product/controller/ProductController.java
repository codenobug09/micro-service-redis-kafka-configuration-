package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceInterface productServiceInterface;
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productServiceInterface.getById(id);
    }
    @PostMapping
    public Product create(@RequestBody Product p){
        return productServiceInterface.create(p);
    }
    @PutMapping("/{id}")
    public Product update(@RequestBody Product p, @PathVariable Long id){
       return productServiceInterface.update(p, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productServiceInterface.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
