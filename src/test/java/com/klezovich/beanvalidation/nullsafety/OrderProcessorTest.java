package com.klezovich.beanvalidation.nullsafety;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    private  OrderProcessor processor = new OrderProcessor();

    @Test
    void testNonNullWorksAsEpected() {

        assertThrows(NullPointerException.class, () -> processor.processOrder(null));
    }

}