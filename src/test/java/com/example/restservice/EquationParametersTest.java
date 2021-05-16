package com.example.restservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquationParametersTest {
    @Test
    void testEquals() {
        EquationParameters equationParameters1 = new EquationParameters(3, 8);
        EquationParameters equationParameters2 = new EquationParameters(3, 8);
        boolean result = equationParameters1.equals(equationParameters2);
        Assertions.assertTrue(result);
    }
}
