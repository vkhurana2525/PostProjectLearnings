package com.example.springbootrabbitmqpoc.controller;

import com.example.springbootrabbitmqpoc.publisher.RabbitMQproducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private RabbitMQproducer rabbitMQproducer;
    public MessageController(RabbitMQproducer rabbitMQproducer) {
        this.rabbitMQproducer=rabbitMQproducer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQproducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMq");
    }
}

