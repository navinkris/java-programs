/*
 * 8. Abstract Class vs Interface
  Q8: Create an abstract class Animal with a method makeSound(). 
  Create classes Dog and Cat that extend Animal. Also, create an interface Pet with methods play() and getName(). 
  Implement this interface in Dog and Cat. Demonstrate the differences between abstract classes and interfaces.

  Concepts Tested: Abstract Classes, Interfaces, Multiple Inheritance.
 */

abstract class Animal {
  public abstract void makeSound();
}

interface Pet {
  public void play();
  public void getName();
}

class Dog extends Animal implements Pet{
    private String name;
    
    public Dog(String name) {
      this.name = name;
    }
    
    @Override
    public void getName() {
      System.out.println("Name of the dog is "+this.name);
    }

    @Override
    public void makeSound() {
      System.out.println("Woof Woof");
    }

    @Override
    public void play() {
      System.out.println("Dog playing with ball");
    }

}

class Cat extends Animal implements Pet{

  private String name;
    
  public Cat(String name) {
    this.name = name;
  }
  
  @Override
  public void getName() {
    System.out.println("Name of the cat is "+this.name);
  }

  @Override
  public void makeSound() {
    System.out.println("Meow Meow");
  }

  @Override
  public void play() {
    System.out.println("Cat playing with thread ball");
  }
}

public class AnimalAbsInt {
  public static void main(String[] args) {
      Dog dog = new Dog("Snoopy");
      dog.getName();
      dog.makeSound();
      dog.play();

      Cat cat = new Cat("Misty");
      cat.getName();
      cat.makeSound();
      cat.play();
  }
}
