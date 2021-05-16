package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Equation {
    @JsonProperty("First parameter")
    private int a;
    @JsonProperty("Second parameter")
    private int b;
    @JsonProperty("Root of the equation")
    private int x;
    @JsonProperty("Equation")
    private String str;

    public Equation() {

    }

    public Equation(int a, int b) {
        this.a = a;
        this.b = b;
        setEquation();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getX() {
        return x;
    }

    public String getStr() {
        return str;
    }

    public void setEquation() {
        this.x = b - a;
        this.str = "x + " + a + " = " + b;
    }
}
