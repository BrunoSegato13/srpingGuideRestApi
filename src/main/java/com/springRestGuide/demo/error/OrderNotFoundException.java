package com.springRestGuide.demo.error;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException (Long id){
        super("Could not found order " + id );
    }
}
