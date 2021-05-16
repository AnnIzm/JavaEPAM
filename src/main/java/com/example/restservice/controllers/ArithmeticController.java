package com.example.restservice.controllers;

import com.example.restservice.Arithmetic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArithmeticController {
    private static final Logger logger = LogManager.getLogger(ArithmeticController.class);
    @Autowired
    Arithmetic arithmetic;

    @GetMapping("/arithmetic")
    public Arithmetic arithmeticController() {
        logger.info("Visited arithmetic controller");
        return arithmetic;
    }
}
