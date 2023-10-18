package app.controller;

import app.model.JobPostedEvent;
import app.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {
    private final KafkaProducerService kafkaProducerService;

    public APIController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/job-posted")
    public void postJobPostedEvent(@RequestBody JobPostedEvent jobPostedEvent) {
        kafkaProducerService.sendJobPostedEvent(jobPostedEvent);
    }

//    @PostMapping("/job-apply")
//    public void postJobApplyedEvent(@RequestBody Object jobApplyedEvent) {
//        kafkaProducerService.sendJobApplyedEvent(jobApplyedEvent);
//    }
//
//    @PostMapping("/proposal-sent")
//    public void postProposalSentEvent(@RequestBody Object proposalSentEvent) {
//        kafkaProducerService.sendProposalSentEvent(proposalSentEvent);
//    }
//
//    @PostMapping("/closed-deal")
//    public void postClosedDealEvent(@RequestBody Object closedDealEvent) {
//        kafkaProducerService.sendClosedDealEvent(closedDealEvent);
//    }
}
