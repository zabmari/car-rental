# Car Rental System – Technical Assessment

This project implements a simplified car rental system in Java.  
It allows reserving cars of different types (SUV, Sedan, Van) for a selected date and duration.  
The number of cars of each type is limited, and the system prevents conflicting reservations.

---

## Features
- Car reservation by type
- Prevention of double booking for the same car
- Detection of overlapping date ranges
- Support for multiple car types
- Unit tests covering all core scenarios

---

## How to run tests
mvn test 

---

## Architecture Overview
- **CarType** – enum defining available car categories
- **Car** – represents a single vehicle
- **Reservation** – stores reservation details (car, start date, duration)
- **CarInventory** – holds available cars and allows filtering by type
- **CarRentalService** – core business logic for availability checks and reservation creation

All data is stored in memory, without persistence, to keep the design intentionally lightweight for the assessment.

---

## AI Usage
AI assistance was used to accelerate boilerplate creation and refine the domain model.  
Prompts were iteratively adjusted to:
- enforce clean and minimal OOP structure
- avoid unnecessary complexity
- ensure correctness through unit tests
- validate edge cases such as overlapping reservations

All logic was manually reviewed and verified with automated tests.

---

## Gaps & Potential Improvements
If more time were available, the system could be extended with:
- Reservation cancellation
- Input validation (e.g., negative days, past dates)
- Persistence layer (database or repository abstraction)
- Pricing model
- REST API for external integration  
