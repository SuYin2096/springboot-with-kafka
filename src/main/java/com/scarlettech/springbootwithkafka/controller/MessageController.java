package com.scarlettech.springbootwithkafka.controller;

import com.scarlettech.springbootwithkafka.payload.Student;
import com.scarlettech.springbootwithkafka.producer.KafkaJsonProducer;
import com.scarlettech.springbootwithkafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String mesg){

        kafkaProducer.sendMessage(mesg);
        return ResponseEntity.ok("Message queued successfully.");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student mesg){

        kafkaJsonProducer.sendMessage(mesg);
        return ResponseEntity.ok("Message queued successfully as JSON.");
    }
}
