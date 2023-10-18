package app.service;

import app.model.JobPostedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, JobPostedEvent> kafkaTemplate;
    private static final String TOPIC = "job-posted-topic"; // Replace with your topic name

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, JobPostedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJobPostedEvent(JobPostedEvent jobPostedEvent) {
        kafkaTemplate.send(TOPIC, jobPostedEvent);
    }
}
