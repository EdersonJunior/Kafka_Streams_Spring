package app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Value("${kafka.topic.jobPost}")
    private String kafkaTopicName;

    @KafkaListener(topics = "${kafka.topic.jobPost}")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
