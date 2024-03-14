package com.scarlettech.springbootwithkafka.consumer;

import com.scarlettech.springbootwithkafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

  // @KafkaListener(topics = "alibi", groupId = "myGroup")
    public void consumeMessage(String mesg){
        log.info(String.format("Consuming the message from alibi topic:::  %s", mesg));
    }

    @KafkaListener(topics = "alibi", groupId = "myGroup")
    public void consumeJsonMessage(Student student){
        log.info(String.format("Consuming the message from alibi topic:::  %s", student));
    }
}
