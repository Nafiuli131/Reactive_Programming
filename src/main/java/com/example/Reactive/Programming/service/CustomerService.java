package com.example.Reactive.Programming.service;

import com.example.Reactive.Programming.dao.CustomerDao;
import com.example.Reactive.Programming.dto.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao dao;

    //traditional approach
    public List<Customers> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customers> customers = dao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers;
    }

    public Flux<Customers> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customers> customers = dao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers;
    }
}
