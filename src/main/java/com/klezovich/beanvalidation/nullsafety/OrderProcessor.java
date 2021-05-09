package com.klezovich.beanvalidation.nullsafety;

import lombok.NonNull;

public class OrderProcessor {

    boolean processOrder(@NonNull Order order) {

        // Processess object1 ...
        // Takes 1 hour
        // var matrix = object1.calculateComplexMatrix();

        // Processing order
        //order.computePriceUsingMatrix(matrix);

        int cost = order.getCost();

        return true;
    }

    boolean processOrderExpress(@NonNull Order order) {
        if( order == null ) {
            return false;
        }

        return false;
    }
}
