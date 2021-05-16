package com.example.restservice;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Cache {
    private final Map<EquationParameters, Equation> equationHashMap = new HashMap<>();

    public boolean searchEquation(EquationParameters equationParameters) {
        return equationHashMap.containsKey(equationParameters);
    }

    public Equation getEquation(EquationParameters equationParameters) {
        return equationHashMap.get(equationParameters);
    }

    public void addEquation(EquationParameters equationParameters, Equation equation) {
        equationHashMap.put(equationParameters, equation);
    }

    public Collection<Equation> getCollection() {
        return equationHashMap.values();
    }
}