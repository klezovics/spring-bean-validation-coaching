package com.klezovich.beanvalidation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class ValidateParametersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidParametersAreValidatedOK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/validatePathVariable/5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

        mockMvc.perform(MockMvcRequestBuilders.get("/validateRequestParameter")
                .param("param", "5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    void testInvalidRequestParamReturnBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/validatePathVariable/1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print());

        mockMvc.perform(MockMvcRequestBuilders.get("/validateRequestParameter")
                .param("param", "1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print());
    }

}