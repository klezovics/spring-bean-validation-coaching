package com.klezovich.beanvalidation.customvalidator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IpAddressValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void testIpAddressValidatedCorrectly() {
        assertEquals(0, validator.validate( new InputWithCustomValidator("111.111.111.111")).size());
        assertEquals(1, validator.validate( new InputWithCustomValidator("not.an.ip")).size());
    }

}