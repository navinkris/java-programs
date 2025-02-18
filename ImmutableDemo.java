// Step 1: Make the class final so it can't be extended
final class ImmutablePerson {
  // Step 2: Make all the fields private and final
  private final String name;
  private final int age;

  // Step 3: Initialize fields through the constructor
  public ImmutablePerson(String name, int age) {
    this.age = age;
    this.name = name;
  }

  // Step 4: Provide only getters ( no setters )
  public String getName() {
    return this.name;
  }
  
  public int getAge() {
    return age;
  }
}

public class ImmutableDemo {
  public static void main(String[] args) {
    ImmutablePerson person = new ImmutablePerson("Alice", 30);
    System.out.println(person.getName());
    System.out.println(person.getAge());

    // person.age = 35 // Not allowed (Compile-time error)
    // person.setName("Bob"); // No setter method
  }
}
  
