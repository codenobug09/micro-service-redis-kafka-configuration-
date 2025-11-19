package com.example.order.service;

import com.example.order.client.ProductClient;
import com.example.order.dto.ProductDto;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;
    @Cacheable(value = "product", key = "#id")
    public ProductDto getProductById(Long id) {
        return productClient.getProduct(id);
    }

}
