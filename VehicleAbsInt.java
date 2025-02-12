/*
  3. Abstraction & Interfaces
  Q3: Create an interface Vehicle with methods start(), stop(), and getFuelType(). 
  Implement this interface in classes Car, Bike, and Truck. 
  Demonstrate calling these methods through the interface reference.

  Concepts Tested: Interfaces, Abstraction, Polymorphism.
*/


interface Vehicle {
  public void start();
  public void stop();
  public void getFuelType();
}

class Car implements Vehicle {

    @Override
    public void start() {
      System.out.println("Car started");
    }

    @Override
    public void stop() {
      System.out.println("Car stopped");
    }

    @Override
    public void getFuelType() {
      System.out.println("Car fuel - Petrol or Diesel");
    }
}

class Bike implements Vehicle {
  @Override
    public void start() {
      System.out.println("Bike started");
    }

    @Override
    public void stop() {
      System.out.println("Bike stopped");
    }

    @Override
    public void getFuelType() {
      System.out.println("Bike fuel - Petrol");
    }
}

class Truck implements Vehicle {
  @Override
    public void start() {
      System.out.println("Truck started");
    }

    @Override
    public void stop() {
      System.out.println("Truck stopped");
    }

    @Override
    public void getFuelType() {
      System.out.println("Truck fuel - Diesel");
    }
}

public class VehicleAbsInt {
  public static void main(String[] args) {
      Vehicle car = new Car();
      car.start();
      car.stop();
      car.getFuelType();

      Vehicle bike = new Bike();
      bike.start();
      bike.stop();
      bike.getFuelType();

      Vehicle truck = new Truck();
      truck.start();
      truck.stop();
      truck.getFuelType();
  }
}
