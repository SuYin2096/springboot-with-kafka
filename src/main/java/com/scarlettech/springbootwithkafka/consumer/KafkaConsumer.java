package com.scarlettech.springbootwithkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "alibi", groupId = "myGroup")
    public void consumeMessage(String mesg){
        log.info(String.format("Consuming the message from alibi topic:::  %s", mesg));
    }
}
