package com.example.order.client;

import com.example.order.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public ProductDto getProduct(Long id) {
        return new ProductDto(0L, id, "UNKNOWN (fallback)", 0.0);
    }
}
