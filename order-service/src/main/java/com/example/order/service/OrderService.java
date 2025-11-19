package com.example.order.service;

import com.example.order.dto.ProductDto;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;


    @Transactional
    public ProductDto createOrder(Long productId) {
        ProductDto p = productService.getProductById(productId);
        Order o = Order.builder()
                .productName(p.name())
                .productId(p.id())
                .price(p.price())
                .build();

        Order saved = orderRepository.save(o);
        ProductDto product = ProductDto.builder()
                .id(saved.getId())
                .name(saved.getProductName())
                .price(saved.getPrice())
                .build();
        kafkaTemplate.send("orders-topic", product);

        return product;
    }
}
