package com.klezovich.beanvalidation;

import com.klezovich.beanvalidation.controller.UserController;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidUserDtoValidatesOK() throws Exception {
        var user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testInvalidUserDtoNotValidated() throws Exception {
        String user = "{\"name\": \"\", \"email\" : \"bob@domain.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$.name", Is.is("Name is mandatory")));
    }

    @Test
    public void testValidUserDtoWithAddressValidatesOK() throws Exception {
        var user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\", \"address\": {\"streetName\":\"Downleaze\", \"houseNumber\": 1 }}";

        mockMvc.perform(MockMvcRequestBuilders.post("/users_with_address")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testInvalidUserDtoWithAddressFailsValidation() throws Exception {
        var user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\", \"address\": {\"streetName\":\"Downleaze\", \"houseNumber\": 0 }}";

        mockMvc.perform(MockMvcRequestBuilders.post("/users_with_address")
                .content(user)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(print())
                .andExpect(jsonPath("$['address.houseNumber']", Is.is("must be greater than or equal to 1")));
    }
}
