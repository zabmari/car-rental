package com.example.carrental;

public class Car {
    private final String id;
    private final CarType type;

    public String getId() {
        return id;
    }

    public CarType getType() {
        return type;
    }

    public Car(String id, CarType type) {
        this.id = id;
        this.type = type;
    }
    
    
}
