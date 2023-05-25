package com.javaLearning.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController {

    @GetMapping("/customers/{customerId}")
    public String getCustomer(@PathVariable String customerId) {
        return "Customer: " + customerId;
    }
}
