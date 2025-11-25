package com.example.user.kafka;

import com.example.user.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    @KafkaListener(topics = "orders-topic", groupId = "order-group")
    public void listen(User order){
        System.out.println("[KafkaConsumer] Received order event: " + order);
    }
}
