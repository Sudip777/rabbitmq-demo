package com.sudip.demorabbitmq.controller;

import com.sudip.demorabbitmq.dto.User;
import com.sudip.demorabbitmq.producer.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {
    private final RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage( @RequestBody  User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to RabbitMQ...");
    }
}
