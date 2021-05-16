package com.example.restservice.controllers;

import com.example.restservice.Counter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    private static final Logger logger = LogManager.getLogger(RequestController.class);

    @GetMapping("/request")
    public String requestController() {
        logger.info("Visited request controller");
        return ("Amount of requests: "+ Counter.INSTANCE.getCounter());
    }
}
