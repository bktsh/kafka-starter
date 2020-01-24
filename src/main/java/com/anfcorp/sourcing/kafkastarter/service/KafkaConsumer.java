package com.anfcorp.sourcing.kafkastarter.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "java_in_use_topic", groupId = "0")
    public void listen(String message) {
        System.out.println("Received Messasge in group 0: " + message);
    }

    @KafkaListener(topics = "generated-in-java")
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + "from partition: " + partition);
    }

    @KafkaListener( topics = "test2", containerFactory = "filterKafkaListenerContainerFactory")
    public void listenTest2(String message) {
        if(message.contains("World")){
            System.out.println("listenTest2 1: " + message);
        }else {
            System.out.println("listenTest2 2: " + message);
        }
    }
}
