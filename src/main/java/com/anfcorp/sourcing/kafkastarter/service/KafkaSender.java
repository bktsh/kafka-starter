package com.anfcorp.sourcing.kafkastarter.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaSender {

    @Autowired
    @Qualifier("topic1")
    NewTopic appTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    String kafkaTopic = "java_in_use_topic";

    public void send(String message) {
        kafkaTemplate.send(kafkaTopic, message);
    }


    public void sendTest2(String message) {
        kafkaTemplate.send("test2", message);
    }


    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(appTopic.name(), message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) { System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
