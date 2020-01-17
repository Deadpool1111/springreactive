package com.reactive.api;

import com.reactive.service.ReactiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@Slf4j
public class ReactiveAPI {

    @Autowired
    private ReactiveService reactiveService;

    @GetMapping(value = "/flux",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> fluxMode(){

       // log.info("Entered thread is : {}",Thread.currentThread().getName());

        Flux<Integer> stringFlux = Flux.range(0,10)
                .log()
                .delayElements(Duration.ofSeconds(1));

        return stringFlux;






//        //log.info("Returned thread is : {}",Thread.currentThread().getName());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stringFlux);

    }
}
