package com.klezovich.beanvalidation;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    private String email;
}