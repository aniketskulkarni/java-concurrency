package com.learnwithaniket.pizza;

public class PizzaDelivery implements Runnable {

    private String deliveryAddress;

    public PizzaDelivery(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public void run() {
        System.out.println("Deliver pizza to " + deliveryAddress);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Error" + e);
        }
        System.out.println("Pizza Delivered!!!");
    }
}
