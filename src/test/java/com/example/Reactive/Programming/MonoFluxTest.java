package com.example.Reactive.Programming;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void monoTest(){
        //single data entry
        //mono is publisher
        Mono<String> mono = Mono.just("Hello").log();
        mono.subscribe(System.out::println);
    }

    @Test
    public void fluxTest(){
        //multiple data entry
        Flux<String> flux = Flux.just("hello", "nafiul", "islam")
                .concatWithValues("after")
                .log();
        flux.subscribe(System.out::println);
    }
}
