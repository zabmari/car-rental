package com.example.carrental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRentalService {

    private final CarInventory carInventory;
    private final List<Reservation> reservations = new ArrayList<>();

    public CarRentalService(CarInventory carInventory) {
        this.carInventory = carInventory;
    }
    public Optional<Reservation> reserve(CarType type, LocalDate start, int days) {
        List<Car> cars = carInventory.getCarsByType(type);

        for (Car car : cars) {
            if (isAvailable(car, start, days)) {
                Reservation r = new Reservation(car, start, days);
                reservations.add(r);
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    private boolean isAvailable(Car car, LocalDate start, int days) {
        LocalDate end = start.plusDays(days);

        return reservations.stream()
                .filter(r -> r.getCar().getId().equals(car.getId()))
                .noneMatch(r ->
                        start.isBefore(r.getEndDate()) &&
                                end.isAfter(r.getStartDate())
                );
    }
}
