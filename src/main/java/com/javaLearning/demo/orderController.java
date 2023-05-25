package com.javaLearning.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class orderController {

    @GetMapping("/orders/{customerId}")
    public String getCustomer(@PathVariable String customerId) {
        RestTemplate restTemplate=new RestTemplate();
        String customerApiUrl = "http://localhost:8080/customers/"+customerId;
        return restTemplate.getForObject(customerApiUrl,String.class);
    }

}
