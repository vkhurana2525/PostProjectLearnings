package com.example.springbootrabbitmqpoc.controller;

import com.example.springbootrabbitmqpoc.dto.User;
import com.example.springbootrabbitmqpoc.publisher.RabbitMQJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageJsonController {

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendMessage(user);
        System.out.println(user.getFirstName());
        return ResponseEntity.ok("Json message sent to rabbit mq");

    }
}
