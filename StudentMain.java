import java.util.*;

class Student {
  private int id;
  private String name;
  private String course;
  
  public Student(int id, String name, String course) {
    this.id = id;
    this.name = name;
    this.course = course;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getCourse() {
    return this.course;
  }
  
  public void setCourse(String course) {
    this.course = course;
  }
  
  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + "', course='" + course + "'}";
  }
}

class StudentService {
  private Map<Integer, Student> studentMap = new HashMap<>();
  
  public void addStudent(Student student) {
    studentMap.put(student.getId(), student);
    System.out.println("Added student: "+student);
  }
  
  public Student getStudentById(int id) {
    return studentMap.get(id);
  }
  
  public List<Student> getAllStudents() {
    return new ArrayList<>(studentMap.values());
  }
  
  public void deleteStudentById(int id) {
    Student removed = studentMap.remove(id);
    if (removed != null) {
      System.out.println("Deleted student: "+removed);
    }
  }
  
  public void updateStudent(int id, String newName, String newCourse) {
    Student student = studentMap.get(id);
    if (student != null) {
      student.setName(newName);
      student.setCourse(newCourse);
      System.out.println("Updated student: "+student);
    } else {
      System.out.println("No student found with ID "+id);
    }
  }
}

public class StudentMain {
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      StudentService service = new StudentService();
      int choice;
      
      do {
        System.out.println("\n--- Student Managemnet Menu ---");
        System.out.println("1. Add Student");
        System.out.println("2. Get Student by ID");
        System.out.println("3. Get All Students");
        System.out.println("4. Delete Student");
        System.out.println("5. Update Student");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        choice = read.nextInt();
        
        switch(choice) {
          case 1:
            System.out.println("Enter ID: ");
            int id = read.nextInt();
            read.nextLine();
            System.out.println("Enter Name: ");
            String name = read.nextLine();
            System.out.println("Enter Course: ");
            String course = read.nextLine();
            service.addStudent(new Student(id, name, course));
            break;
          case 2:
            System.out.print("Enter ID: ");
            int idToGet = read.nextInt();
            Student found = service.getStudentById(idToGet);
            System.out.println(found != null ? found : "Student not found.");
            break;
          case 3:
            System.out.println("All students: ");
            service.getAllStudents().forEach(System.out::println);
            break;
          case 4:
            System.out.print("Enter ID to delete: ");
            int idToDelete = read.nextInt();
            service.deleteStudentById(idToDelete);
            break;
          case 5:
            System.out.print("Enter ID to update: ");
            int idToUpdate = read.nextInt();
            read.nextLine();
            System.out.println("Enter new name: ");
            String newName = read.nextLine();
            System.out.println("Enter new course: ");
            String newCourse = read.nextLine();
            service.updateStudent(idToUpdate, newName, newCourse);
            break;
          case 0:
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice.");
        }
      } while(choice!=0);
      read.close();
  }
}
