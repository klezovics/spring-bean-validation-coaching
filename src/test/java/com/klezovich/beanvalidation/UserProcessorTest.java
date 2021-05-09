package com.klezovich.beanvalidation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserProcessorTest {

    @Autowired
    private UserProcessor processor;

    @Test
    void testValidBeanProcessedCorrectly() {
        processor.process( new User("ak","ak@ak.com") );
    }

    @Test
    void testInvalidBeanThrowsException() {
        var user = new User();
        assertThrows(ConstraintViolationException.class, () -> processor.process( user ));
    }

}