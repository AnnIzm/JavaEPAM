package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Arithmetic {
    @JsonProperty("Max x")
    private int max;
    @JsonProperty("Min x")
    private int min;
    @JsonProperty("Max first parameter")
    private int maxA;
    @JsonProperty("Max second parameter")
    private int maxB;
    @JsonProperty("Min first parameter")
    private int minA;
    @JsonProperty("Min second parameter")
    private int minB;
    @JsonProperty("Average")
    private double average;

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMaxA(int maxA) {
        this.maxA = maxA;
    }

    public void setMaxB(int maxB) {
        this.maxB = maxB;
    }

    public void setMinA(int minA) {
        this.minA = minA;
    }

    public void setMinB(int minB) {
        this.minB = minB;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
