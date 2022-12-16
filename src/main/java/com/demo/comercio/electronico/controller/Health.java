package com.demo.comercio.electronico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class Health {

    @GetMapping
    public Mono<String> health() {
        return Mono.just("app is running");
    }
}
