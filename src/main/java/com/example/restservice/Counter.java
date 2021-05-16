package com.example.restservice;

import com.example.restservice.controllers.EquationController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public enum Counter {
    INSTANCE;
    private int counter = -1;
    private static final Logger logger = LogManager.getLogger(EquationController.class);

    public void increment() {
        this.counter++;
        logger.info("Counter: " + counter);
    }

    public int getCounter() {
        return counter;
    }
}
