import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

class Person
{
    private String name;
    private Integer age;
    
    public Person() 
    {
        Random ran = new Random();
        
        this.name = ran.ints(97, 122+1).limit(7)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public Integer getAge() { return age; }
    public String getName() { return name; }
}

class ComparisonProvider
{
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
    
    public int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
}

public class MethodReferencesDemo {
    public static void print(String s) {
        System.out.println(s);
    }
    
    public static int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
    
    public static int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
    
    public static <T> List<T> getObjectList(int length, Supplier<T> objectSupply) {
        List<T> list = new ArrayList<>();
        for(int i=0; i<length;i++) {
            list.add(objectSupply.get());
        }
        return list;
    }
    
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        Arrays.stream(names).forEach(MethodReferencesDemo::print);
    
        List<String> pl = Arrays.asList(names);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Navin", 30));
        personList.add(new Person("Vaishnavi", 29));
        personList.add(new Person("KG", 1));
        System.out.println();
        
        Collections.sort(personList, MethodReferencesDemo::compareByName);
        System.out.println("Sort by Name :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);
        System.out.println();
        
        Collections.sort(personList, MethodReferencesDemo:: compareByAge);
        System.out.println("Sort by Age:");
        personList.stream().map(x -> x.getAge()).forEach(System.out::println);
        System.out.println();
        
        ComparisonProvider comparator = new ComparisonProvider();
        Collections.sort(personList, comparator::compareByName);
        System.out.println("Sort by Name :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);
        System.out.println();
        
        Collections.sort(personList, comparator::compareByAge);
        System.out.println("Sort by Age :");
        personList.stream().map(x -> x.getName()).forEach(System.out::println);
        
        Collections.sort(pl, String::compareToIgnoreCase);
        personList.forEach(System.out::println);
        
        List<Person> personList1 = getObjectList(5, Person::new);
        personList1.stream().map(x -> x.getName()).forEach(System.out::println);
        
    }
}
