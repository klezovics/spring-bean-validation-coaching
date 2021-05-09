package com.klezovich.beanvalidation;

import com.klezovich.beanvalidation.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Slf4j
@Component
@Validated
public class UserProcessor {

    void process(@Valid UserDto user) {
      log.info("Processing {}", user);
    }
}
