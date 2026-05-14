package com.example.carrental;

import java.time.LocalDate;

public class Reservation {
    private final Car car;
    private final LocalDate startDate;
    private final int days;
    
    public Reservation(Car car, LocalDate startDate, int days) {
        this.car = car;
        this.startDate = startDate;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }
}
