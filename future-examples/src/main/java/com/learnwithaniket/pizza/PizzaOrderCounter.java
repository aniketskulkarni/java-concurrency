package com.learnwithaniket.pizza;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class PizzaOrderCounter implements Function<String, Integer> {

    public AtomicInteger orderCount = new AtomicInteger();

    @Override
    public Integer apply(String orderId) {
        System.out.println("Processing order:" + orderId);
        return Integer.valueOf(orderCount.addAndGet(1));
    }
}
