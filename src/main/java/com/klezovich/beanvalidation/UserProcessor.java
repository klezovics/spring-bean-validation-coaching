package com.klezovich.beanvalidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Slf4j
@Component
@Validated
public class UserProcessor {

    void process(@Valid User user) {
      log.info("Processing {}", user);
    }
}
