package com.example.carrental;

import java.util.ArrayList;
import java.util.List;

public class CarInventory {

    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCarsByType(CarType type) {
        return cars.stream()
                .filter(c -> c.getType() == type)
                .toList();
    }
}
