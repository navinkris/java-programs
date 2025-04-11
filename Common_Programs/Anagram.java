import java.util.*;

public class Anagram {
  
    // Using Brute force Approach: Sorting
    public static boolean isAnagramBF(String s, String t) {
      char[] sc = s.toCharArray();
      char[] tc = t.toCharArray();
      Arrays.sort(sc);
      Arrays.sort(tc);
      if(new String(sc).equals(new String(tc))) {
        return true;
      }
      return false;
    }
    
    // Counting two Hashaps
    public static boolean isAnagramCHM(String s, String t) {
      HashMap<Character, Integer> count1 = new HashMap<>();
      HashMap<Character, Integer> count2 = new HashMap<>();
      count1 = count(count1, s);
      count2 = count(count2, t);
      return count1.equals(count2) ? true : false;
    }
    
    public static HashMap<Character, Integer> count(HashMap<Character, Integer> count, String str) {
      for(int i=0; i<str.length(); i++) {
        Character c = str.charAt(i);
        if(count.containsKey(c)) {
          count.put(c, count.get(c)+1);
          continue;
        }
        count.put(c, 1);
      }
      return count;
    }
    
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      String s1 = read.next();
      String s2 = read.next();
      System.out.println("Are the given Strings Anagram "+ isAnagramBF(s1, s2));
      System.out.println("Are the given Strings Anagram via HashMaps "+isAnagramCHM(s1, s2));
  }
}
