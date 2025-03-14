import java.util.*;

public class NonRepCharacter {
  
    public static char findFirstNonRepeatedChar(String str) {
      Map<Character, Integer> charCountMap = new LinkedHashMap<>();
      
      for(char c: str.toCharArray()) {
        charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
      }
      
      for (Map.Entry<Character, Integer> entry: charCountMap.entrySet()) {
        if (entry.getValue() == 1) {
          return entry.getKey();
        }
      }
      
      return 0;
    }
    
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      String input = read.nextLine();
      char result = findFirstNonRepeatedChar(input);
      if (result!=0) {
        System.out.println("First non repeated character: " + result);
      } else {
        System.out.println("No non-repeated character found.");
      }
  }
}
