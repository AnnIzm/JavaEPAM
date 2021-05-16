package com.example.restservice;

import com.example.restservice.exceptions.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquationTest {
    @Test
    void testEquationConstructor() {

        Equation test = new Equation(2, 3);
        int result1 = 1;
        test.setEquation();
        int result2 = test.getX();
        Assertions.assertEquals(result1, result2);
    }

    @Test
    void testEquationNoParameters() {
        boolean result = true;
        try {
            Equation equation = new Equation();
            equation.setEquation();
        } catch (BadRequestException e) {
            result = false;
        }
        Assertions.assertTrue(result);
    }
}
