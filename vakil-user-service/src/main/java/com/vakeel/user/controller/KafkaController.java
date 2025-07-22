package com.vakeel.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vakeel.user.kafka.service.KafkaProducerService;

@RestController
@RequestMapping("/user/kafka")
public class KafkaController {

	@Autowired
	private KafkaProducerService kafkaProducerService;

//    public KafkaController(KafkaProducerService kafkaProducerService) {
//        this.kafkaProducerService = kafkaProducerService;
//    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam String message) {
        kafkaProducerService.sendMessage("my-topic", message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}
