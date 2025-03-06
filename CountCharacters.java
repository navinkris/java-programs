import java.util.*;

public class CountCharacters {
    
    public static String compressString(String str) {
      if (str == null || str.isEmpty()) {
        return "";
      }
      
      StringBuilder result = new StringBuilder();
      int count = 1;
      
      for (int i = 1; i < str.length(); i++) {
        if(str.charAt(i) == str.charAt(i-1)) {
          count++;
        } else {
          result.append(str.charAt(i-1)).append(count);
          count = 1;
        }
      }
      
      result.append(str.charAt(str.length() - 1)).append(count);
      
      return result.toString();
    }
  
    public static void main(String[] args) {
      Scanner read = new Scanner(System.in);
      String input = read.nextLine();
      System.out.println(compressString(input));
  }
}
