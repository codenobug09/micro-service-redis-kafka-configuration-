package com.example.order.controller;

import com.example.order.dto.ProductDto;
import com.example.order.model.Order;
import com.example.order.service.OrderService;
import com.example.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/{productId}")
    public ResponseEntity<ProductDto> create(@PathVariable Long productId){
        return ResponseEntity.ok(orderService.createOrder(productId));
    }
}
