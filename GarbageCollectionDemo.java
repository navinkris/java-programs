public class GarbageCollectionDemo {
  public static void main(String[] args) {
      for (int i=0; i< 10000; i++) {
        new Object();
      }
      System.gc();
      System.out.println("Garbage Collection requested");
  }
}
