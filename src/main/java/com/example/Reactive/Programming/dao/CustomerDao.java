package com.example.Reactive.Programming.dao;

import com.example.Reactive.Programming.dto.Customers;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {
    //traditionalApproach

    private static void sleepExecution(int i){
        try {
            Thread.sleep(i* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //traditional approach
    public List<Customers> getCustomers(){
        return IntStream.rangeClosed(1,10)
                .peek(customer -> sleepExecution(2)) // Sleep for 2 seconds for each customer
                .peek(i-> System.out.println("processing count " + i))
                .mapToObj(i->new Customers(i,"customer "+i))
                .collect(Collectors.toList());
    }

    public Flux<Customers> getCustomersStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("processing count " + i))
                .map(i->new Customers(i,"customerStream "+i));
    }
}
