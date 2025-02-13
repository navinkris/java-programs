import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
  private static final List<byte[]> memoryLeakList = new ArrayList<>();

  public static void main(String[] args) {
      try {
        while (true) { 
          memoryLeakList.add(new byte[1024 * 1024]);
          System.out.println("Memory growing..." + memoryLeakList.size() + " MB");
        }
      } catch (OutOfMemoryError e) {
        System.err.println("OutofMemoryError occurred!");
      }
  }
}
