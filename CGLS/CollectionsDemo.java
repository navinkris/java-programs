import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

class Student {
  int rollno;
  String name;

  public Student(int rollno, String name) {
    this.rollno = rollno;
    this.name = name;
  }

  @Override
  public String toString() {
    return rollno + ": " + name;
  }
}

class Number implements Comparable<Number> {
  int v;

  public Number(int v) {
    this.v = v;
  }

  @Override
  public String toString() {
    return String.valueOf(v);
  }

  @Override
  public int compareTo(Number o) {
    return this.v - o.v;
  }
}

class SortbyRoll implements Comparator<Student> {
  @Override
  public int compare(Student a, Student b) {
    return a.rollno - b.rollno;
  }
}

public class CollectionsDemo {
  public static void main(String[] args) {
    
    // List interface Example
    List<String> li = new ArrayList<>();
    li.add("Java");
    li.add("Python");
    li.add("DSA");
    li.add("C++");
    System.out.println("Elements of List are: ");

    for (String s: li) {
      System.out.println(s);
    }

    System.out.println("Element at Index 1: " + li.get(1));

    li.set(1, "Javascript");
    System.out.println("Updated List: "+li);

    li.remove("C++");
    System.out.println("List After removing Element: "+li);

    int i = li.indexOf("Java");
    System.out.println("First Occurence of Java is at Index: "+i);

    int l = li.lastIndexOf("Javascript");
    System.out.println("Last Occurence of Javascript at Index: "+l);

    System.out.println("The object at index 2 is: "+li.get(2));

    System.out.println("Is Python part of the list : "+li.contains("Python"));
  
    // Vector example
    int n = 5;

    List<Integer> v = new Vector<>(n);

    for(i=1; i<=n; i++) {
      v.add(i);
    }

    System.out.println(v);

    v.remove(3);

    System.out.println(v);

    for(Integer in: v) {
      System.out.println(in);
    }
  
    List<Integer> s = new Stack<>();

    for(i=1; i<=n; i++) {
      s.add(i);
    }

    System.out.println(s);

    s.remove(3);
    System.out.println(s);

    for(i=0;i<s.size(); i++) {
      System.out.println(s.get(i) + " ");
    }

    // Linked List Example
    List<String> link = new LinkedList<>();

    link.add("Navin");
    link.add("Rakesh");
    link.add("Krishnamurthi");
    link.add("Vaishnavi");

    for(String value: link) {
      System.out.println(value);
    }

    link.remove("Rakesh");

    System.out.println(link);

    // Set example in Java
    Set<String> set1 = new HashSet<>();

    set1.add("Navin");
    set1.add("Vaishnavi");
    set1.add("Navin");
    System.out.println(set1);
    set1.remove("Vaishnavi");
    System.out.println(set1);

    Set<Integer> a = new HashSet<>();

    a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));

    Set<Integer> b = new HashSet<>();
    b.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));

    Set<Integer> union = new HashSet<>(a);
    union.addAll(b);
    System.out.println("Union of the two sets");
    System.out.println(union);

    Set<Integer> intersection = new HashSet<>(a);
    intersection.retainAll(b);
    System.out.println("Intersection of the two sets ");
    System.out.println(intersection);

    Set<Integer> difference = new HashSet<>(a);
    difference.removeAll(b);
    System.out.println("Difference of the two Set");
    System.out.println(difference);

    // Enum set
    enum Gfg{ CODE, LEARN, CONTRIBUTE, QUIZ, MCQ}

    Set<Gfg> set2;

    set2 = EnumSet.of(Gfg.QUIZ, Gfg.CONTRIBUTE, Gfg.LEARN, Gfg.CODE);
    System.out.println("Set 2: "+set2);

    // LinkedHashSet
    Set<String> lhs = new LinkedHashSet<>();
    lhs.addAll(Arrays.asList(new String[] {"Hello", "World", "Here"}));
    System.out.println(lhs);
    lhs.remove("Here");
    System.out.println(lhs);
    Iterator<String> it = lhs.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }

    // TreeSet
    Set<String> ts = new TreeSet<>();
    ts.addAll(Arrays.asList(new String[] {"Hello", "Ulagamee", "Hello", "Kekudhaaa?"}));
    System.out.println(ts);

    // Queue Example
    Queue<String> queue = new LinkedList<>();
    queue.add("apple");
    queue.add("banana");
    queue.add("cherry");
    System.out.println("Queue: "+queue);
    String front = queue.remove();
    System.out.println("Removed element: "+front);
    System.out.println("Queue after removal: "+queue);
    queue.add("date");
    String peeked = queue.peek();
    System.out.println("Peeked element: "+peeked);
    System.out.println("Queue after peek: "+queue);

    // Priority Queue example
    PriorityQueue<Integer> pq = new PriorityQueue<>(10);

    pq.add(3);
    pq.add(1);
    pq.add(2);
    pq.add(4);
    pq.add(5);
    System.out.println("Priority queue: "+pq);
    System.out.println("Peek: "+pq.peek());
    pq.poll();
    System.out.println("Priority queue after removing top element: "+pq);
    System.out.println("Does the queue contain 3? "+pq.contains(3));
    System.out.println("Size of queue: "+pq.size());
    pq.clear();
    System.out.println("Is the queue empty? "+pq.isEmpty());

    // Deque example
    Deque<Integer> de_que = new ArrayDeque<>(10);
    de_que.addAll(Arrays.asList(new Integer[]{20, 30, 50, 10, 40}));
    System.out.println(de_que);
    de_que.clear();
    de_que.addFirst(534);
    de_que.addFirst(291);
    de_que.addLast(24);
    de_que.addLast(14);
    System.out.println(de_que);

    // HashMap example
    HashMap<Integer, String> hm1 = new HashMap<>(5, 0.75f);
    HashMap<Integer, String> hm2 = new HashMap<>(3, 0.5f);
    hm1.put(1, "one");
    hm1.put(2, "two");
    hm1.put(3, "three");
    hm2.put(4, "four");
    hm2.put(5, "five");
    hm2.put(6, "six");
    System.out.println("Mappings of HashMap hm1 are: "+hm1);
    System.out.println("Mappings of HashMap hm2 are: "+hm2);

    // LinkedHashmap example
    LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
    lhm.put(3, "Geeks");
    lhm.put(2, "Geeks");
    lhm.put(1, "Geeks");
    System.out.println(lhm);
    lhm.put(4, "For");
    System.out.println(lhm);
    lhm.remove(4);
    System.out.println(lhm);
    for (Map.Entry<Integer, String> mapElement : lhm.entrySet()) {
        Integer key = mapElement.getKey();
        String val = mapElement.getValue();
        System.out.println(key+" : "+val);
    }

    //Hashtable implementation
    Hashtable<String, Integer> ht = new Hashtable<>();
    ht.put("one", 1);
    ht.put("two", 2);
    ht.put("three", 3);
    System.out.println("Initial HashTable "+ht);
    ht.put("two", 4);
    System.out.println("After Update HashTable "+ht);
    for(Map.Entry<String, Integer> e : ht.entrySet()) {
      System.out.println(e.getKey() + " " + e.getValue());
    }

    //SortedSet implementation
    SortedSet<String> ss = new TreeSet<>();
    ss.add("India");
    ss.add("Australia");
    ss.add("South Africa");
    ss.add("India");
    System.out.println(ss);
    ss.remove("Australia");
    System.out.println("Set after removing Australia "+ts);
    System.out.println("Iterating over set: ");
    Iterator<String> ite = ss.iterator();
    while(ite.hasNext()) {
      System.out.println(ite.next());
    }

    Number[] num = { new Number(4), new Number(1), new Number(7), new Number(2)};
    System.out.println("Before sorting: "+ Arrays.toString(num));
    Arrays.sort(num);
    System.out.println("After sorting: "+ Arrays.toString(num));
    List<Student> students = new ArrayList<>();
    students.add(new Student(111, "Mayank"));
    students.add(new Student(131, "Anshul"));
    students.add(new Student(121, "Solanki"));
    students.add(new Student(101, "Aggarwal"));

    Collections.sort(students, new SortbyRoll());
    System.out.println("Sorted by Roll Number ");
    for(i=0;i<students.size();i++) {
      System.out.println(students.get(i));
    }

  }
}
