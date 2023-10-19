package app.service;

import app.model.JobPostedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, JobPostedEvent> kafkaTemplate;
    @Value("${kafka.topic.jobPost}")
    private String kafkaTopicName;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, JobPostedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJobPostedEvent(JobPostedEvent jobPostedEvent) {
        kafkaTemplate.send(kafkaTopicName, jobPostedEvent);
    }
}
