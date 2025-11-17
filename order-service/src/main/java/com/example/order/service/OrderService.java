package com.example.order.service;

import com.example.order.dto.ProductDto;
import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class OrderService {

    private final ProductService productService;
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderService(ProductService productService,
                        OrderRepository orderRepository,
                        KafkaTemplate<String, Object> kafkaTemplate) {
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public Order createOrder(Long productId) {
        ProductDto p = productService.getProductById(productId);
        Order o = Order.builder()
                .productName(p.name())
                .productId(p.id())
                .price(p.price())
                .build();

        Order saved = orderRepository.save(o);
        kafkaTemplate.send("orders-topic", saved);

        return saved;
    }
}
