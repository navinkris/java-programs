/*

  4. Encapsulation
  Q4: Create a Student class with private fields name, rollNumber, and marks. 
  Provide public getter and setter methods for these fields. 
  Ensure that marks can't be set to negative values.

  Concepts Tested: Encapsulation, Data Hiding, Validation.
*/

import java.util.Scanner;

class Student {
  private String name;
  private int rollNo;
  private int marks;

    public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getRollNo() {
      return rollNo;
  }

  public void setRollNo(int rollNo) {
      this.rollNo = rollNo;
  }

  public int getMarks() {
      return marks;
  }

  public void setMarks(int marks) {
      this.marks = marks;
  }
}


public class StudentEncap {
  public static void main(String[] args) {
    Student s1 = new Student();
    Scanner read = new Scanner(System.in);
    System.out.println("Enter the name of the Student ");
    s1.setName(read.nextLine());
    System.out.println("Enter the roll number of the Student ");
    s1.setRollNo(read.nextInt());
    System.out.println("Enter the marks of the student: ");
    int marks = read.nextInt();
    if(marks > 0) {
      s1.setMarks(marks);
    } else {
      System.out.println("Please re-enter a non negative value for marks");
      s1.setMarks(read.nextInt());
    }
    System.out.println("Student Details");
    System.out.println("================");
    System.out.println("Name: "+s1.getName());
    System.out.println("Roll No: "+s1.getRollNo());
    System.out.println("Marks: "+s1.getMarks());
    read.close();
  }
}
