import java.time.LocalDate;

public class SalesLeadTracker {
  public static void main(String[] args) {
    var person1 = new Person.PersonBuilder("Navin", "Krishnamurthi")
            .dateOfBirth(LocalDate.of(1994, 9, 9))
            .emailAddress("navin@example.com")
            .build();

    addPersonToLeadTracker(person1);

    var person2 = new Person.PersonBuilder("Vaishnavi", "K")
            .middleName("Navin")
            .phoneNumber("123456789")
            .build();

    addPersonToLeadTracker(person2);
  }

  static void addPersonToLeadTracker(Person person) {
    System.out.println("A new lead was added to the lead tracker: \n" + person);
  }
}

class Person
{
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final LocalDate dateOfBirth;
  private final String emailAddress;
  private final String phoneNumber;

  private Person(PersonBuilder personBuilder) {
    this.firstName = personBuilder.firstName;
    this.middleName = personBuilder.middleName;
    this.lastName = personBuilder.lastName;
    this.dateOfBirth = personBuilder.dateOfBirth;
    this.emailAddress = personBuilder.emailAddress;
    this.phoneNumber = personBuilder.phoneNumber;
    if (firstName == null || lastName == null) {
      throw new IllegalArgumentException("First name and last name must not be null");
    }
  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("firstName=").append(firstName);
        sb.append(", middleName=").append(middleName);
        sb.append(", lastName=").append(lastName);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", emailAddress=").append(emailAddress);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append('}');
        return sb.toString();
    }

  

  public static class PersonBuilder {
    
    private final String firstName;
    private String middleName;
    private final String lastName;
    private LocalDate dateOfBirth;
    private String emailAddress;
    private String phoneNumber;

    public PersonBuilder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public PersonBuilder middleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    public PersonBuilder dateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public PersonBuilder emailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
      return this;
    }

    public PersonBuilder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
