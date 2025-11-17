package com.example.order.kafka;

import com.example.order.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    @KafkaListener(topics = "orders-topic", groupId = "order-group")
    public void listen(Order order){
        System.out.println("[KafkaConsumer] Received order event: " + order);
    }
}
