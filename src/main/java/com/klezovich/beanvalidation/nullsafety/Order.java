package com.klezovich.beanvalidation.nullsafety;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Builder
public class Order {

    private long id;
    private long itemCode;

    //@NonNull
    private int cost;
}
