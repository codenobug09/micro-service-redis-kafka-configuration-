package com.example.order.service;

import com.example.order.client.ProductClient;
import com.example.order.dto.ProductDto;
import com.example.order.repository.OrderRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProductService(ProductClient productClient, OrderRepository orderRepository, KafkaTemplate<String, Object> kafkaTemplate){
        this.productClient = productClient;
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Cacheable(value = "product", key = "#productId")
    public ProductDto getProductById(Long id) {
        return productClient.getProduct(id);
    }

}
