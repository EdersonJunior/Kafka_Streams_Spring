package app.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "jobs")
    public void consumeMessage(String message) {
        // Handle the received message
        System.out.println("Received message: " + message);
    }
}
