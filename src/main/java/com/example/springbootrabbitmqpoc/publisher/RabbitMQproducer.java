package com.example.springbootrabbitmqpoc.publisher;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQproducer {
    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.queue.exchange}")
    private String exchange;

//    private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMQproducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQproducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void sendMessage(String message){
//        LOGGER.info(String.format("Message sent -> %s",message));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
