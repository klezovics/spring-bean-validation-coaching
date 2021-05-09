package com.klezovich.beanvalidation.repository;

import com.klezovich.beanvalidation.dto.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void testHibernateHasValidationEnabledByDefault() {
        var address = Address.builder().streetName("AK").houseNumber("0").build();
        assertThrows(ConstraintViolationException.class, () -> {
            repository.save(address);
            entityManager.flush();
        });
    }
}