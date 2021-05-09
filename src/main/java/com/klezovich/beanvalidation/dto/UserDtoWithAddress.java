package com.klezovich.beanvalidation.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoWithAddress {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @Valid
    private Address address;
}