package com.learnwithaniket.pizza;

import java.util.UUID;
import java.util.function.Supplier;

public class PizzaOrderJob implements Supplier<String> {
    private String orderId;
    private String orderInfo;

    public PizzaOrderJob(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String get() {
        this.orderId = processOrder();
        return this.orderId;
    }

    private String processOrder() {
        // Process order with orderInfo
        System.out.println("Order accepted:" + orderInfo);
        return UUID.randomUUID().toString();
    }
}
