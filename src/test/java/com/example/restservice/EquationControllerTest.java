package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EquationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerSuccess(){
        try {
            this.mockMvc.perform(get("/equation?a=5&b=18"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().json("{\"Root of the equation\":13,\"Equation\":x + 5 = 18}"));
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
