package com.example.carrental;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class CarRentalServiceTest {

    @Test
    void shouldReserveCarWhenAvailable() {
        CarInventory carInventory = new CarInventory();
        carInventory.addCar(new Car("1", CarType.SUV));
        CarRentalService carRentalService = new CarRentalService(carInventory);
        var result = carRentalService.reserve(CarType.SUV, LocalDate.of(2025, 1, 1), 3);

        assertTrue(result.isPresent());
        assertEquals("1", result.get().getCar().getId());
    }

    @Test
    void shouldNotReserveCarWhenUnavailable() {
        CarInventory carInventory = new CarInventory();
        CarRentalService carRentalService = new CarRentalService(carInventory);
        var result = carRentalService.reserve(CarType.SEDAN, LocalDate.now(), 3);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldNotReserveCarWhenAlreadyReserved() {
        CarInventory carInventory = new CarInventory();
        carInventory.addCar(new Car("1", CarType.SUV));
        CarRentalService carRentalService = new CarRentalService(carInventory);
        carRentalService.reserve(CarType.SUV, LocalDate.now(), 3);
        var result = carRentalService.reserve(CarType.SUV, LocalDate.now(), 3);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldNotReserveCarWhenDatesOverlap() {
        CarInventory carInventory = new CarInventory();
        carInventory.addCar(new Car("1", CarType.VAN));
        CarRentalService carRentalService = new CarRentalService(carInventory);
        carRentalService.reserve(CarType.VAN, LocalDate.now(), 3);
        var result = carRentalService.reserve(CarType.VAN, LocalDate.now().plusDays(2), 3);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReserverDifferentCar() {
        CarInventory carInventory = new CarInventory();
        carInventory.addCar(new Car("1", CarType.SUV));
        carInventory.addCar(new Car("2", CarType.SEDAN));
        CarRentalService carRentalService = new CarRentalService(carInventory);
        var sedan = carRentalService.reserve(CarType.SEDAN, LocalDate.now(), 3);
        var suv = carRentalService.reserve(CarType.SUV, LocalDate.now(), 3);

        assertTrue(sedan.isPresent());
        assertTrue(suv.isPresent());
    }

    @Test
    void shouldReserveCarForAFutureDate() {
        CarInventory carInventory = new CarInventory();
        carInventory.addCar(new Car("1", CarType.SUV));
        CarRentalService carRentalService = new CarRentalService(carInventory);
        var result = carRentalService.reserve(CarType.SUV, LocalDate.now().plusDays(1), 3);

        assertTrue(result.isPresent());
    }
}
