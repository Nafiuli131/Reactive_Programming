package com.example.Reactive.Programming.controller;

import com.example.Reactive.Programming.dto.Customers;
import com.example.Reactive.Programming.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    //traditional approach
    @GetMapping
    public List<Customers> getAllCustomers() {
        return service.loadAllCustomers();
    }

    //reactive approach
    @GetMapping("/stream")
    public Flux<Customers> getAllCustomersStream(){
        return service.loadAllCustomersStream();
    }
}
