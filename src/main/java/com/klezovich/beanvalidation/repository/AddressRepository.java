package com.klezovich.beanvalidation.repository;

import com.klezovich.beanvalidation.dto.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
