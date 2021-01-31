package com.learnwithaniket.pizza;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PizzaApplication {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        PizzaOrderJob pizzaOrderJob = new PizzaOrderJob("Veg Corn Pizza");
        CompletableFuture<String> pizzaOrderFuture = CompletableFuture.supplyAsync(pizzaOrderJob, executor);
        CompletableFuture<Integer> pizzaOrderCounterFuture = pizzaOrderFuture.thenApply(new PizzaOrderCounter());
        PizzaDelivery pizzaDelivery = new PizzaDelivery("Pune Maharashtra");
        CompletableFuture<Void> pizzaDeliveryFuture = pizzaOrderCounterFuture.thenRunAsync(pizzaDelivery, executor);
        pizzaDeliveryFuture.get();
    }
}
