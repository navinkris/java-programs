/*
 * 9. Real-World Design: Parking Lot System
  Q9: Design a simple parking lot system with classes for ParkingLot, Vehicle, and ParkingSpot.
  Implement methods to park and remove vehicles, and to check the availability of spots.

  Concepts Tested: OOP Design, Real-World Problem Solving, Encapsulation, Inheritance.
 */

// Parking Lot System Demonstrating OOP Concepts

import java.util.*;

// Enum to represent vehicle types
enum VehicleType {
    CAR, BIKE, TRUCK
}

// Vehicle class
abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}

// Car class inheriting Vehicle
class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}

// Bike class inheriting Vehicle
class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}

// Truck class inheriting Vehicle
class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}

// Parking Spot class
class ParkingSpot {
    private int spotNumber;
    private Vehicle vehicle;  // Null if spot is empty

    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

// Parking Lot class
class ParkingLot {
    private List<ParkingSpot> spots;

    public ParkingLot(int numberOfSpots) {
        spots = new ArrayList<>();
        for (int i = 1; i <= numberOfSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    // Method to park a vehicle
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.parkVehicle(vehicle);
                System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at spot " + spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("No available spots for vehicle " + vehicle.getLicensePlate());
        return false;
    }

    // Method to remove a vehicle
    public boolean removeVehicle(String licensePlate) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getVehicle().getLicensePlate().equals(licensePlate)) {
                spot.removeVehicle();
                System.out.println("Vehicle " + licensePlate + " removed from spot " + spot.getSpotNumber());
                return true;
            }
        }
        System.out.println("Vehicle " + licensePlate + " not found in parking lot.");
        return false;
    }

    // Method to display available spots
    public void displayAvailableSpots() {
        System.out.println("Available Parking Spots:");
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                System.out.println("Spot " + spot.getSpotNumber() + " is available.");
            }
        }
    }
}

public class ParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(5);

        Vehicle car1 = new Car("ABC123");
        Vehicle bike1 = new Bike("BIKE007");
        Vehicle truck1 = new Truck("TRUCK999");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(truck1);

        parkingLot.displayAvailableSpots();

        parkingLot.removeVehicle("BIKE007");

        parkingLot.displayAvailableSpots();
    }
}
