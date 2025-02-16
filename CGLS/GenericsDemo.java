
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Area<T> {
  private T t;

  public void add(T t) {
    this.t = t;
  }

  public T get() { return t; }

  public void getArea() {}

}

class MultiMap<K, V> {
  private TreeMap<K, List<V>> treeMap;
  private int size;

  public MultiMap() {
    treeMap = new TreeMap<>();
    size = 0;
  }

  public void put(K key, V value) {
    treeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    ++size;
  }

  public List<V> get(K key) {
    return this.containsKey(key) ? treeMap.get(key) : new ArrayList<>();
  }

  public void removeAll(K key) {
    if (this.containsKey(key)) {
      size -= treeMap.get(key).size();
      treeMap.remove(key);
    }
  }

  public boolean remove(K key, V value) 
    {
        boolean isKeyPresent = this.containsKey(key);
        if (!isKeyPresent) 
        {
            return false;
        }

        boolean isValuePresent = treeMap.get(key).contains(value);
        if (isValuePresent) 
        {
            treeMap.get(key).remove(value);
            --size;
        }

        return isKeyPresent && isValuePresent;
    }

    public int size() 
    {
        return this.size;
    }

    public boolean containsKey(K key) 
    {
        return treeMap.containsKey(key);
    }

    @Override
    public String toString() 
    {
        StringBuilder printMultiMap = new StringBuilder("{\n");

        for (K key : treeMap.keySet()) 
        {
            printMultiMap.append(key).append(" = ").append(treeMap.get(key)).append("\n");
        }

        printMultiMap.append("}");

        return printMultiMap.toString();
    }
}

public class GenericsDemo {
  public static void main(String[] args) {
      Set<Integer> set1 = new HashSet<>();
      set1.add(100);
      set1.add(Integer.valueOf(101));
      Set<String> set2 = new HashSet<>();
      set2.add("GeeksForGeeks");
      set2.add("Generics");
      for(Integer data: set1) {
        System.out.printf("Integer Value: %d\n", data);
      }
      Iterator<String> stringIt = set2.iterator();
      while(stringIt.hasNext()) {
        System.out.printf("String Value: %s\n", stringIt.next());
      }

      String arr[] = {"gfg",  "code",    "quiz",   "program", 
                "code", "website", "quiz",   "gfg", 
                "java", "gfg",     "program" };
      Map<String, Integer> map = new HashMap<>();
      for(int i=0; i<arr.length; i++) {
        if(map.containsKey(arr[i])) {
          int count = map.get(arr[i]);
          map.put(arr[i], count+1);
        } else {
          map.put(arr[i], 1);
        }
      }
      System.out.println(map.get("gfg"));
      System.out.println(map.get("code"));

      Area<Integer> rectangle = new Area<Integer>();
      Area<Double> circle = new Area<Double>();
      rectangle.add(10);
      circle.add(2.5);
      System.out.println(rectangle.get());
      System.out.println(circle.get());

      MultiMap<Character, Integer> multiMap = new MultiMap<>();

        // adding values in multimap
        multiMap.put('A', 1);
        multiMap.put('B', 2);
        multiMap.put('C', 3);
        multiMap.put('A', 4);
        multiMap.put('B', 5);
        multiMap.put('A', 6);
        multiMap.put('D', 7);
        multiMap.put('D', 8);

        // Printing Multimap
        System.out.println("The Key and values in the MultiMap are: ");
        System.out.println(multiMap);

        // Printing size
        System.out.println("\nSize Of multiMap : " + multiMap.size());

        // Remove specific key-value pair
        multiMap.remove('A', 4);

        // MultiMap After performing remove operations
        System.out.println("\nAfter performing remove operation");
        System.out.println("The Key and values in the MultiMap are: ");
        System.out.println(multiMap);
        System.out.println("\nSize Of multiMap : " + multiMap.size());

        // This will remove all the values associated with the key
        multiMap.removeAll('D');

        // MultiMap After performing remove operations
        System.out.println("\nAfter performing removeAll operation");
        System.out.println("The Key and values in the MultiMap are: ");
        System.out.println(multiMap);
        System.out.println("\nSize Of multiMap : " + multiMap.size());

        // get values
        System.out.println("Values in the MultiMap associated with the key are: ");
        System.out.println(multiMap.get('B'));

        // check key is present or not
        System.out.println("\nIs 'A' Present?" + multiMap.containsKey('A'));

        // MultiMap After performing all operations
        System.out.println("\nKey and Values in MultiMap : ");
        System.out.println(multiMap);
  }
}
