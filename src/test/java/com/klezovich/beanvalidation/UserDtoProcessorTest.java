package com.klezovich.beanvalidation;

import com.klezovich.beanvalidation.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDtoProcessorTest {

    @Autowired
    private UserProcessor processor;

    @Test
    void testValidBeanProcessedCorrectly() {
        processor.process( new UserDto("ak","ak@ak.com") );
    }

    @Test
    void testInvalidBeanThrowsException() {
        var user = new UserDto();
        assertThrows(ConstraintViolationException.class, () -> processor.process( user ));
    }

}