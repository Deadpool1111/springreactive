package com.reactive.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReactiveService {

    public String serve(Integer val){
        log.info(" Thread started processing : "+Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        log.info(" Thread completed processing : "+Thread.currentThread().getName());

        return val.toString();

    }
}
