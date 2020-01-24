package com.anfcorp.sourcing.kafkastarter.web;

import com.anfcorp.sourcing.kafkastarter.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaWebController {

    @Autowired
    KafkaSender kafkaSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) {
        kafkaSender.send(message);
        return "Message sent to the Kafka Topic java_in_use_topic Successfully";
    }

    @GetMapping(value = "/producer2")
    public String producer2(@RequestParam("message") String message) {
        kafkaSender.sendMessage(message);
        return "Message sent to the Kafka Topic newTopic Successfully";
    }

    @GetMapping(value = "/producer3")
    public String producer3(@RequestParam("message") String message) {
        kafkaSender.sendTest2(message);
        return "Message sent to the Kafka Topic test2 Successfully";
    }

}
