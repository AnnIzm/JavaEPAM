package com.example.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.concurrent.Executor;

public class Status {

    public static ResponseEntity handleNotifications(@RequestParam("notification") String itemid) {
        // parse here the values
        return ResponseEntity.ok().build(); //OR ResponseEntity.ok("body goes heare");
    }
    /*

        @Bean(name = "threadPoolTaskExecutor")
        public Executor threadPoolTaskExecutor() {
            return new ThreadPoolTaskExecutor();
        }
    @Async("threadPoolTaskExecutor")
    public void asyncGetStatus() {

    }

 */

    /*public ResponseEntity<?> create(@RequestBody String data) {
        if(everything_fine) {
            return new ResponseEntity<>(RestModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */

}
