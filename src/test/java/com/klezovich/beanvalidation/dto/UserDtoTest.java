package com.klezovich.beanvalidation.dto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDtoTest {

    private static Validator validator;

    @BeforeAll
    static void setup() {
        var factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testConstraintsOnNameWorkAsExpected() {
        var violations = validator.validate(UserDto.builder().email("email").build());
        //Name is empty
        assertEquals(1, violations.size());

        violations = validator.validate(UserDto.builder().name("AK").email("email").build());
        assertEquals(0, violations.size());
    }

    @Test
    void testConstraintsOnEmailWorkAsExpected() {
        var violations = validator.validate(UserDto.builder().name("AK").email("").build());
        //Email is empty
        assertEquals(1, violations.size());

        violations = validator.validate(UserDto.builder().name("AK").email("email").build());
        assertEquals(0, violations.size());
    }

}