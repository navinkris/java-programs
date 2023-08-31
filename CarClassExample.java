// Program to demonstrate all the OOPS concepts in Java in terms of a car example.

public class CarClassExample {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla Altis", 4);
        car.displayInfo();
        car.startEngine();
        car.stopEngine();
    }
}

class Vehicle {
    private String brand;
    private String model;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    
    public Car(String brand, String model, int numberOfDoors) {
        super(brand, model);
        this.numberOfDoors = numberOfDoors;
    }
    
    public void startEngine() {
        System.out.println("Car engine started");
    }
    
    public void stopEngine() {
        System.out.println("Car engine stopped");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}
