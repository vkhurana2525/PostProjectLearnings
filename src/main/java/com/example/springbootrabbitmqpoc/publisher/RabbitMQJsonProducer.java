package com.example.springbootrabbitmqpoc.publisher;


import com.example.springbootrabbitmqpoc.dto.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;

    @Value("${rabbitmq.queue.exchange}")
    private String jsonExchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingjsonkey;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(User user){
        rabbitTemplate.convertAndSend(jsonExchange,routingjsonkey,user);
    }
}
