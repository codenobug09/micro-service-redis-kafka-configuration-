package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.service.OrderService;
import com.example.order.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){ this.orderService = orderService; }

    @PostMapping("/{productId}")
    public ResponseEntity<Order> create(@PathVariable Long productId){
        return ResponseEntity.ok(orderService.createOrder(productId));
    }
}
