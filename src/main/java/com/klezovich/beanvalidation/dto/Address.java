package com.klezovich.beanvalidation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String streetName;

    @Min(1)
    private String houseNumber;
}
