public class StackOverflowExample {
  public static void recursiveMethod() {
    recursiveMethod();
  }

  public static void main(String[] args) {
      try {
        recursiveMethod();
      } catch (StackOverflowError e) {
        System.err.println("StackOverflowError occurred!");
      }
  }
}
